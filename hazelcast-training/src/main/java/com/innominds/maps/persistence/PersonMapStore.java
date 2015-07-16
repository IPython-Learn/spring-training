package com.innominds.maps.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hazelcast.core.MapStore;

public class PersonMapStore implements MapStore<String, Person> {

	Log logger = LogFactory.getLog(PersonMapStore.class);

	Map<String, Person> map = new HashMap<String, Person>();

	@Override
	public Person load(String key) {

		logger.info("load " + key);

		return map.get(key);
	}

	@Override
	public Map<String, Person> loadAll(Collection<String> keys) {

		logger.info("loadAllby keys " + keys);

		return map;
	}

//	@Override
//	public Iterable<String> loadAllKeys() {
//		logger.info("loadAllKeys  ");
//
//		return map.keySet();
//	}

	@Override
	public Set<String> loadAllKeys() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void store(String key, Person value) {
		logger.info("saving  element " + key + "=" + value);
		map.put(key, value);
	}

	@Override
	public void storeAll(Map<String, Person> temp) {
		logger.info("saving all the elements " + temp);
		map.putAll(temp);
	}

	@Override
	public void delete(String key) {
		logger.info("delete key = " + key);
		map.remove(key);
	}

	@Override
	public void deleteAll(Collection<String> keys) {

		logger.info("deleteAll keys " + keys);
		for (String k : keys) {
			map.remove(k);
		}
	}

}
