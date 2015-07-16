package com.lyris.mesa.tracker.store;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.hazelcast.core.MapStore;
import com.lyris.mesa.tracker.AbstractTracker;
import com.lyris.mesa.tracker.db.DatabaseUtil;

/**
 * mapStore instance to store into mysqlDatabase
 * 
 * @author ThirupathiReddy
 *
 */
public class ScheduleItemMapStore implements MapStore<String, Object> {

	/** Reference to logger */
	private final Logger logger = Logger.getLogger(ScheduleItemMapStore.class);

	private static final String MAP_NAME = AbstractTracker.SCHEDULE_ITEM_MAP;

	public ScheduleItemMapStore() {
		logger.info("ScheduleItemMapStore  created ....");
	}

	@Override
	public Object load(String key) {
		logger.info("load method  gets invoked with key : " + key);
		return DatabaseUtil.load(key, MAP_NAME);

	}

	@Override
	public Map<String, Object> loadAll(Collection<String> keys) {
		logger.info("loadAll method  gets invoked with keys : " + keys);
		return DatabaseUtil.loadAll(keys, MAP_NAME);
	}

	@Override
	public Set<String> loadAllKeys() {
		logger.info("loadAllKeys method  gets invoked");
		return DatabaseUtil.loadAllKeys(MAP_NAME);
	}

	@Override
	public void store(String key, Object value) {
		logger.info("store method invoked with key:" + key + " value: " + value);
		DatabaseUtil.store(key, value, MAP_NAME);
	}

	@Override
	public void storeAll(Map<String, Object> map) {
		logger.info("storeAll method invoked " + map);
		DatabaseUtil.storeAll(map, MAP_NAME);
	}

	@Override
	public void delete(String key) {
		logger.info("delete method invoked with key : " + key);
		DatabaseUtil.deleteRecord(key, MAP_NAME);
	}

	@Override
	public void deleteAll(Collection<String> keys) {
		logger.info("deleteAll method invoked with keys: " + keys);
		DatabaseUtil.deleteRecords(keys, MAP_NAME);
	}

}
