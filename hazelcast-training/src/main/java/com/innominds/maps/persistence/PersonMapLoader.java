package com.innominds.maps.persistence;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.hazelcast.core.MapLoader;

public class PersonMapLoader  implements MapLoader<String, Person>{

	@Override
	public Person load(String key) {
		
		return null;
	}

	@Override
	public Map<String, Person> loadAll(Collection<String> keys) {
		
		return null;
	}

//	@Override
//	public Iterable<String> loadAllKeys() {
//		
//		return null;
//	}
	
	@Override
	public Set<String> loadAllKeys() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
