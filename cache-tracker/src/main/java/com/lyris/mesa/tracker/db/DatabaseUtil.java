package com.lyris.mesa.tracker.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * <p>
 * Database utility which is used to inside the hazelCast mapStore
 * </p>
 * 
 * @author ThirupathiReddy V
 *
 */
public class DatabaseUtil implements SQLQuery {

	/** Reference to logger */
	private static final Logger logger = Logger.getLogger(DatabaseUtil.class);

	/** Reference to JDBC Properties */
	private Properties properties = new Properties();

	private static BoneCPDataSource dataSource;

	private DatabaseUtil() {
		logger.info("Creating dataSource Using URL :"
				+ properties.getProperty("database.url"));
		dataSource = new BoneCPDataSource();
		dataSource.setJdbcUrl(properties.getProperty("database.url"));
		dataSource.setDriverClass(properties.getProperty("database.driver"));
		dataSource.setUsername(properties.getProperty("database.user"));
		dataSource.setPassword(properties.getProperty("database.password"));
		dataSource.setIdleMaxAgeInMinutes(10);
		dataSource.setIdleConnectionTestPeriod(5, TimeUnit.MINUTES);
		dataSource.setMaxConnectionsPerPartition(100);
		dataSource.setMaxConnectionAge(10, TimeUnit.MINUTES);

		logger.info("Executing database script  " + getScript());
		dataSource.setInitSQL(getScript());
	}

	public static void main(String[] args) throws SQLException {

		new DatabaseUtil();
		Connection connection = dataSource.getConnection();

		System.out.println(connection);

		System.out.println(connection.getMetaData());
	}

	public static Connection getConnection() throws SQLException {

		synchronized (DatabaseUtil.class) {
			if (dataSource == null) {
				logger.info("Creating singleton dataSource instance ");
				new DatabaseUtil();
			}

			return dataSource.getConnection();
		}
	}

	/**
	 * <p>
	 * executes <b>INSERT INTO tbl_hazelmap (map_key,map_value,map_name)
	 * values(?,?,?) </b>
	 * </p>
	 * 
	 * @param mapKey
	 * @param mapValue
	 * @param mapName
	 */
	public static void store(String mapKey, Object mapValue, String mapName) {
		try {

			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);
			ps.setString(1, mapKey);
			ps.setObject(2, mapValue);
			ps.setString(3, mapName);
			int recordCount = ps.executeUpdate();
			logger.info("Total " + recordCount + " Records Inserted ");
			ps.close();
			conn.close(); // will return into pool
		} catch (SQLException e) {

			if (logger.isDebugEnabled())
				logger.debug("Insertion Failed " + e.getMessage());

			update(mapValue, mapKey, mapName);
		}
	}

	/**
	 * <p>
	 * executes by iterating the map <b> INSERT INTO
	 * tbl_hazelmap(map_key,map_value,map_name) values(?,?,?) </b>
	 * </p>
	 * 
	 * @param map
	 *            map to store
	 * @param mapName
	 *            mapName on which to save
	 */
	public static void storeAll(Map<String, Object> map, String mapName) {
		try {

			Connection conn = getConnection();
			for (Entry<String, Object> entry : map.entrySet()) {
				try {
					PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);
					ps.setString(1, entry.getKey());
					ps.setObject(2, entry.getValue());
					ps.setString(3, mapName);
					int recordCount = ps.executeUpdate();
					logger.info(" Total  Records Inserted " + recordCount);
					ps.close();
				} catch (Exception e) {
					if (logger.isDebugEnabled()) {
						logger.debug(
								"Error while inserting the record.Trying to update with these details ",
								e);
					}
					update(entry.getValue(), entry.getKey(), mapName);
				}
			}

			conn.close(); // will return into pool
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * executes <b> SELECT map_value FROM tbl_hazelmap WHERE map_key=? AND
	 * map_name=?</b>
	 * </p>
	 * 
	 * @param mapKey
	 * @param mapName
	 * @return mapValue as Object
	 */
	public static Object load(String mapKey, String mapName) {

		Object map_value = null;
		try {
			// SELECT map_value FROM tbl_hazelmap WHERE map_key=? AND map_name=?
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_VALUE_BY_KEY);
			ps.setString(1, mapKey);
			ps.setString(2, mapName);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				map_value = rs.getObject("map_value");
			}

			rs.close();
			ps.close();
			conn.close(); // will return into pool
			if (map_value == null) {
				logger.info("There is no Object found with key : " + mapKey);
			} else {
				logger.info("Loaded Object with key : " + mapKey);
			}
		} catch (SQLException e) {
			logger.error("Error while loading entry with key : " + mapKey
					+ "on Map " + mapName, e);
		}
		return map_value;
	}

	/**
	 * <p>
	 * executes <b> SELECT map_key,map_value FROM tbl_hazelmap where map_key=?
	 * AND map_name=? </b> by iterating the list of keys
	 * </p>
	 * 
	 * @param keys
	 *            list of keys
	 * @param map_name
	 * @return map with specified keys along with value
	 */
	public static Map<String, Object> loadAll(Collection<String> keys,
			String mapName) {

		Map<String, Object> mapEntries = new HashMap<String, Object>();

		try {
			Connection conn = getConnection();

			for (String key : keys) {
				PreparedStatement ps = conn
						.prepareStatement(SELECT_KEY_VALUE_BY_KEY);
				ps.setString(1, String.valueOf(key));
				ps.setString(2, String.valueOf(mapName));
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					mapEntries.put(rs.getString(1), rs.getString(2));
				}
				rs.close();
				ps.close();
			}
			conn.close();// will return into pool
			logger.info("Total  values " + mapEntries.size()
					+ " found for the keys " + keys.size());

		} catch (SQLException e) {
			logger.error("Error while loading entry with keys : " + keys
					+ " on Map : " + mapName, e);
		}

		return mapEntries;
	}

	/**
	 * <p>
	 * SELECT map_key FROM tbl_hazelmap where map_name=?
	 * </p>
	 * 
	 * @param mapName
	 * @return Collection of map_key NOTE : if you using 3.5 version of
	 *         hazelCast it should return Iterator
	 */
	public static Set<String> loadAllKeys(String mapName) {
		// SELECT map_key FROM tbl_hazelmap where map_name=?
		HashSet<String> mapKeys = new HashSet<String>();

		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_KEY);
			ps.setString(1, String.valueOf(mapName));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				mapKeys.add(rs.getString("map_key"));
			}
			rs.close();// close resultset
			ps.close(); // close statement
			conn.close(); // will return into pool
			logger.info("Loaded " + mapKeys.size()
					+ " keys found for the map :" + mapName);
		} catch (SQLException e) {
			logger.error("Error while loading keys on map : " + mapName, e);
		}

		return mapKeys;
	}

	/**
	 * 
	 * @param key
	 * @param mapName
	 */
	public static void deleteRecord(String key, String mapName) {
		// DELETE FROM tbl_hazelmap WHERE map_key=? AND map_name=?
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE_KEY);
			ps.setString(1, key);
			ps.setString(2, mapName);

			int recordCount = ps.executeUpdate();
			logger.info("Total $d Records Deleted " + recordCount);
			ps.close();
			conn.close(); // will return into pool
		} catch (SQLException e) {
			logger.error("Error while deleting the record with key : " + key);
		}

	}

	public static void deleteRecords(Collection<String> keys, String mapName) {
		// DELETE FROM tbl_hazelmap WHERE map_key=? AND map_name=?
		try {
			Connection conn = getConnection();

			for (String key : keys) {
				try {
					PreparedStatement ps = conn.prepareStatement(DELETE_KEY);
					ps.setString(1, key);
					ps.setString(2, mapName);
					int recordCount = ps.executeUpdate();
					logger.info("Total Records Deleted " + recordCount);
					ps.close();
				} catch (Exception e) {
					logger.error("Error while deleting the record with key : "
							+ key);
				}
			}

			conn.close(); // will return into pool
		} catch (SQLException e) {
			logger.error("Error while deleting the record with keys : " + keys,
					e);
		}

	}

	/**
	 * <p>
	 * update <b> UPDATE tbl_hazelmap SET map_value=? WHERE map_key=? AND
	 * map_name=? </b>
	 * </p>
	 * 
	 * @param mapValue
	 * @param mapKey
	 * @param mapName
	 */
	public static void update(Object mapValue, String mapKey, String mapName) {

		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);
			ps.setObject(1, mapValue);
			ps.setString(2, mapKey);
			ps.setString(3, mapName);
			int recordCount = ps.executeUpdate();

			ps.close();
			conn.close(); // will return into pool
			logger.info("Record updated successfully with key " + mapKey
					+ " updation count " + recordCount);
		} catch (SQLException e) {
			logger.error(
					"Error while updating the record with key : " + mapKey, e);
		}
	}

	/**
	 * prepares DDL scripts and passed to DataSource which used to create tables
	 * if not exists
	 * 
	 * @return sqlScript
	 */
	private String getScript() {
		logger.info("Loading startup script from script.sql from classPath");
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("script.sql");

		return getStringFromInputStream(is);

	}

	private String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		logger.info("Returning  SQL Script as String ");
		return sb.toString();

	}

	{
		try {
			properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("jdbc.properties"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
