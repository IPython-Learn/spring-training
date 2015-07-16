package com.innominds.maps.persistence;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class PersistenceTest {

	public static void main(String[] args) {

		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
		IMap<String, Person> person = hazelcastInstance.getMap("person");

		person.put("ONE", new Person());


		System.out.println(person.get("ONE"));
		
		hazelcastInstance.shutdown();
	}
}
