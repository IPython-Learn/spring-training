package com.innominds.cache.store;

/**
 * MySQL Queries which are used in MySQLMapStore.
 */

public interface SQLQuery {

    /** The insert query. */
    String INSERT_QUERY = "INSERT INTO tbl_hazelmap(mapkey,mapValue) values(?,?)";

    /** The update query. */
    String UPDATE_QUERY = "UPDATE tbl_hazelmap SET mapValue=? WHERE mapkey=?";

    /** The select query. */
    String SELECT_QUERY = "SELECT mapValue FROM tbl_hazelmap WHERE mapkey=?";

    /** The all keys. */
    String ALL_KEYS = "SELECT mapkey FROM  tbl_hazelmap";

    /** The delete key. */
    String DELETE_KEY = "DELETE FROM tbl_hazelmap WHERE mapkey=?";

}
