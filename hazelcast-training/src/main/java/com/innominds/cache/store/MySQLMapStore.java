package com.innominds.cache.store;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.hazelcast.core.MapStore;

/**
 * <p>
 * MapStore instance would persist cached objects into MySQL Database. with a given delay
 * </p>
 * 
 * @author ThirupathiReddy V
 */
public class MySQLMapStore implements MapStore<String, Object>, SQLQuery {

    /** Reference to logger */
    private Log logger = LogFactory.getLog( " HAZELCAST CACHE MYSQL PERSITENCE " );

    /** jdbcTemplate will handle DB connection. */
    private JdbcTemplate jdbcTemplate;

    /**
     * setting method injected through IOC.
     * 
     * @param jdbcTemplate
     *            the new JDBC template
     */

    public void setJdbcTemplate( final JdbcTemplate jdbcTemplate ) {

        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * load object from Database using given KEY.
     * 
     * @param key
     *            the key
     * @return the object
     */
    @Override
    public Object load( final String key ) {

        logger.info( " checking for persistence entry " + key );

        try {
            final byte[] bytes = jdbcTemplate.queryForObject( SQLQuery.SELECT_QUERY, new Object[] { key }, byte[].class );

            return MySQLMapStore.deserialize( bytes );
        } catch ( final EmptyResultDataAccessException e ) {

            return null;
        }

    }

    /**
     * Load all.
     * 
     * @param keys
     *            the keys
     * @return the map
     */
    @Override
    public Map<String, Object> loadAll( final Collection<String> keys ) {

        final Map<String, Object> map = new HashMap<String, Object>();

        for ( final Iterator<String> iterator = keys.iterator(); iterator.hasNext(); ) {
            final String mapKey = iterator.next();
            final Object mapValue = load( mapKey );
            map.put( mapKey, mapValue );
        }
        logger.info( "Total " + map.size() + " objects loaded " );
        return map;
    }

    /**
     * Load all keys.
     * 
     * @return the sets the
     */
    @Override
    public Set<String> loadAllKeys() {

        final List<String> list = jdbcTemplate.queryForList( SQLQuery.ALL_KEYS, String.class );

        logger.info( "Total keys found " + list.size() );
        return new HashSet<String>( list );
    }

    /**
     * Delete.
     * 
     * @param key
     *            the key
     */
    @Override
    public void delete( final String key ) {

        jdbcTemplate.execute( SQLQuery.DELETE_KEY, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement( final PreparedStatement ps ) throws SQLException, DataAccessException {

                ps.setString( 1, key );
                return ps.execute();
            }
        } );

        logger.info( "Entry with key " + key + "deleted " );

    }

    /**
     * Delete all.
     * 
     * @param keys
     *            the keys
     */
    @Override
    public void deleteAll( final Collection<String> keys ) {

        for ( final Iterator<String> iterator = keys.iterator(); iterator.hasNext(); ) {
            final String mapkey = iterator.next();
            delete( mapkey );
        }

        if ( !keys.isEmpty() ) {
            logger.info( "Total " + keys.size() + "objects deleted. " );
        }
    }

    /**
     * store method save object into DB . if KEY already exist it will update the record with new value
     * 
     * @param key
     *            the key
     * @param value
     *            the value
     */
    @Override
    public void store( final String key, final Object value ) {

        try {

            jdbcTemplate.execute( SQLQuery.INSERT_QUERY, new PreparedStatementCallback<Boolean>() {

                @Override
                public Boolean doInPreparedStatement( final PreparedStatement ps ) throws SQLException, DataAccessException {

                    ps.setString( 1, key );
                    ps.setObject( 2, value );
                    return ps.execute();
                }

            } );

            logger.info( "Entry persisted successfully " + key + " = " + value );

        } catch ( final org.springframework.dao.DuplicateKeyException dke ) {
            logger.info( "Updating  value with existing key = " + key );
            update( key, value );
        }
    }

    /**
     * Update.
     * 
     * @param key
     *            the key
     * @param value
     *            the value
     */
    public void update( final String key, final Object value ) {

        jdbcTemplate.execute( SQLQuery.UPDATE_QUERY, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement( final PreparedStatement ps ) throws SQLException, DataAccessException {

                ps.setObject( 1, value );
                ps.setString( 2, key );
                return ps.execute();
            }

        } );

    }

    /**
     * Store all.
     * 
     * @param map
     *            the map
     */
    @Override
    public void storeAll( final Map<String, Object> map ) {

        final Set<Entry<String, Object>> set = map.entrySet();
        for ( final Iterator<Entry<String, Object>> iterator = set.iterator(); iterator.hasNext(); ) {
            final Entry<String, Object> entry = iterator.next();
            store( entry.getKey(), entry.getValue() );
        }

        logger.info( "Total  " + map.size() + " objects saved." );

    }

    /**
     * convert byte stream into Object.
     * 
     * @param objectBytes
     *            the object bytes
     * @return the object
     */
    public static Object deserialize( final byte[] objectBytes ) {
        final Object obj;
        try {
            final ObjectInputStream objectIn = new ObjectInputStream( new ByteArrayInputStream( objectBytes ) );
            obj = objectIn.readObject();

        } catch ( final Exception e ) {
            return null;
        }
        return obj;
    }

  
}
