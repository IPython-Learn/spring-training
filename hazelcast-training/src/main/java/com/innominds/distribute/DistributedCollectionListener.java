package com.innominds.distribute;

import java.util.Collection;

import com.hazelcast.core.DistributedObject;
import com.hazelcast.core.DistributedObjectEvent;
import com.hazelcast.core.DistributedObjectListener;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class DistributedCollectionListener implements DistributedObjectListener {

    public static void main( String[] args ) {
        
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        hazelcastInstance.addDistributedObjectListener(new DistributedCollectionListener());
        
        Collection<DistributedObject> distributedObjects = hazelcastInstance.getDistributedObjects();
        for (DistributedObject distributedObject : distributedObjects) {
          System.out.println(distributedObject.getName() + "," + distributedObject.getId());
        }
        
        
    }
    
    
    @Override
    public void distributedObjectCreated( DistributedObjectEvent event ) {

        DistributedObject instance = event.getDistributedObject();
        System.out.println("Created " + instance.getName() + "," + instance.getId());
    }
    
    @Override
    public void distributedObjectDestroyed( DistributedObjectEvent event ) {

        DistributedObject instance = event.getDistributedObject();
        System.out.println("Destroyed " + instance.getName() + "," + instance.getId());
    }
}
