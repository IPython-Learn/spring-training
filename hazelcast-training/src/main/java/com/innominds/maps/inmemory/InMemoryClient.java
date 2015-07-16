package com.innominds.maps.inmemory;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class InMemoryClient {

	public static void main(String[] args) {

		System.setProperty("hazelcast.logging.type", "log4j");
		HazelcastInstance client = HazelcastClient.newHazelcastClient();
		IMap<String, User> autTokens = client.getMap("authTokens");

		long start = System.currentTimeMillis();

		System.out.println(autTokens.get("TWO"));

		System.out.println(System.currentTimeMillis() - start);

		System.out.println(autTokens.get("TWO") == autTokens.get("TWO"));
		
		System.out.println(autTokens.get("TWO"));
		
		System.out.println(autTokens.size());

		client.shutdown();
	}
}
