package com.innominds.maps.inmemory;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * 
 * @author ThirupathiReddy V
 *
 */
public class InMemoryMap {

	public static void main(String[] args) {

		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
		IMap<String, User> autTokens = hazelcastInstance.getMap("authTokens");
		
		System.out.println(" authTokens  :  " + autTokens);

		autTokens.put("ONE", new User());
		autTokens.put("TWO", new User());

	}
}
