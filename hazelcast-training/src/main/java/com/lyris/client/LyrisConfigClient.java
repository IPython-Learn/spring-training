package com.lyris.client;

import java.util.Map;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.EntryView;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class LyrisConfigClient {

	public static void main(String[] args) {

		HazelcastInstance client = getClient();
		IMap<String, Map<String, String>> map = client
				.getMap("configurationSettingsMap");
		System.out.println(map.keySet());

		for (String key : map.keySet()) {
			System.err.println(key);
			System.out.println(map.get(key));
			EntryView<String, Map<String, String>> entry = map
					.getEntryView(key);
			System.out.println("size in memory  : " + entry.getCost());
			System.out.println("creationTime    : " + entry.getCreationTime());
			System.out
					.println("expirationTime  : " + entry.getExpirationTime());
			System.out.println("number of hits  : " + entry.getHits());
			System.out
					.println("lastAccessedTime: " + entry.getLastAccessTime());
			System.out
					.println("lastUpdateTime  : " + entry.getLastUpdateTime());
			System.out.println("version         : " + entry.getVersion());
			System.out.println("key             : " + entry.getKey());
			System.out.println("value           : " + entry.getValue());
		}

		client.shutdown();
	}

	public static HazelcastInstance getClient() {

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
		clientConfig.getNetworkConfig().addAddress(
				"dev03-hazelcast.dev.corp.lyris.com");
		HazelcastInstance client = HazelcastClient
				.newHazelcastClient(clientConfig);

		return client;
	}
}
