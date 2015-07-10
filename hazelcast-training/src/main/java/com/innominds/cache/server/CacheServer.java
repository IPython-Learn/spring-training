package com.innominds.cache.server;

import com.hazelcast.core.Hazelcast;

/**
 * This class used to start HazelCast server. if we don't pass any configuration that looks into the classPath.
 * 
 * @author ThirupathiReddy V
 */
public class CacheServer {

    public static void main( String[] args ) {
        Hazelcast.newHazelcastInstance();
    }

}
