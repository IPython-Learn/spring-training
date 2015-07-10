package com.innominds.cache.client;

import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;

/**
 * <p>
 * This class connects to hazelCast nodes mentioned and reads the data in the map
 * </p>
 * 
 * @author ThirupathiReddy V
 */
public class SimpleClient {

    public static void main( String[] args ) {

        HazelcastInstance client = getClient();

        IQueue<String> queue = client.getQueue( "message" );

        queue.offer( "Hello" );
        queue.offer( "World" );
        
        client.shutdown();

    }

    public static void readMap() {
        HazelcastInstance client = getClient();

        // IMap distributed Map from HazelCast which extends Map
        IMap<String, Integer> stockMap = client.getMap( "stock" );

        for ( Entry<String, Integer> entry : stockMap.entrySet() ) {
            System.out.println( entry.getKey() + " = " + entry.getValue() );
        }

        client.getLifecycleService().shutdown();
    }

    public static HazelcastInstance getClient() {

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getGroupConfig().setName( "dev" ).setPassword( "dev-pass" );
      //  clientConfig.getNetworkConfig().addAddress( "192.168.232.80" );
        clientConfig.getNetworkConfig().addAddress( "localhost" );
        HazelcastInstance client = HazelcastClient.newHazelcastClient( clientConfig );

        return client;
    }
}
