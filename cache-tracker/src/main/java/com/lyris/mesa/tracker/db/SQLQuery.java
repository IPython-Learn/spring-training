package com.lyris.mesa.tracker.db;

/**
 * MySQL Queries which are used in MySQLMapStore.
 */

public interface SQLQuery {

	String INSERT_QUERY = "INSERT INTO tbl_hazelmap(map_key,map_value,map_name) values(?,?,?)";
	String UPDATE_QUERY = "UPDATE tbl_hazelmap SET map_value=? WHERE map_key=? AND map_name=?";
	String SELECT_VALUE_BY_KEY = "SELECT map_value FROM tbl_hazelmap WHERE map_key=? AND map_name=?";
	String SELECT_KEY_VALUE_BY_KEY = "SELECT map_key,map_value FROM tbl_hazelmap where map_key=? AND map_name=?";
	String SELECT_KEY = "SELECT map_key FROM  tbl_hazelmap where map_name=?";
	String DELETE_KEY = "DELETE FROM tbl_hazelmap WHERE map_key=? AND map_name=?";


}