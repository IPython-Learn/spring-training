package com.innominds.cache.client;

import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class XmlCacheClient {

    public static void main( String[] args ) {

        HazelcastInstance client = HazelcastClient.newHazelcastClient();

        // perform some operations
        // IMap distributed Map from HazelCast which extends Map
        IMap<String, Integer> stockMap = client.getMap( "stock" );

        for ( Entry<String, Integer> entry : stockMap.entrySet() ) {
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }

        client.getLifecycleService().shutdown();
    }
}
