package com.innominds.eviction;

import java.util.concurrent.TimeUnit;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class EvictionPolicyTest {

    public static void main( String[] args ) {

        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        IMap<String, String> stock = hazelcastInstance.getMap( "stock" );

        stock.put( "ONE", "1" );
        stock.put( "TWO", "2" );
        stock.put( "THREE", "3" );

        // programmatically evict specific entries using below command
        // which can stay only 4 seconds in the map
        stock.put( "FOUR", "4", 4, TimeUnit.SECONDS );
    }
}
