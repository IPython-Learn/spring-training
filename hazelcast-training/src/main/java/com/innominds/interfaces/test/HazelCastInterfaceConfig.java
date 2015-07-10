package com.innominds.interfaces.test;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HazelCastInterfaceConfig {

    public static void main( String[] args ) {

        // bind any interfaces available
        /**
         * Picked Address[192.168.1.4]:5702, using socket ServerSocket[addr=/0:0:0:0:0:0:0:0,localport=5702], bind any local is true
         */
        System.setProperty( "hazelcast.socket.bind.any", "true" );

        // partition table sends across the tables
        System.setProperty( "hazelcast.partition.table.send.interval", "5" );

        // each node try to owns one partitions. if the partition count is less than nodes
        // new node doesn't own partitions
        System.setProperty( "hazelcast.partition.count", "1" );//

        System.setProperty( "hazelcast.logging.type", "log4j" );

        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        System.out.println( hazelcastInstance );

        IMap<String, String> stock = hazelcastInstance.getMap( "stock" );

        stock.put( "ONE", "1" );
        stock.put( "TWO", "2" );
        stock.put( "THREE", "3" );
        // lock this key
        stock.lock( "ONE" );

    }
}
