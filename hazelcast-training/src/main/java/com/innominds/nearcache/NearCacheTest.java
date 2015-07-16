package com.innominds.nearcache;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class NearCacheTest {

	public static void main(String[] args) {

		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
		IMap<String, String> tokens = hazelcastInstance.getMap("tokensRO");

		long start = System.currentTimeMillis();

		tokens.put("ONE", "1");
		tokens.put("TWO", "2");
		tokens.put("THREE", "3");
		
		String tokenOne = tokens.get("ONE");

		System.out.println("READING TIME :  "
				+ (System.currentTimeMillis() - start));
		System.out.println(" token = " + tokenOne);

	}
}
