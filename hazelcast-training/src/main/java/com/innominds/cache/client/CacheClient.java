package com.innominds.cache.client;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

/**
 * This example demonstrates how to connect to hazelCast server which is located in the remote server. Using Java Class configuration.(without using
 * hazelcast.xml) The client has two operation modes because of the distributed nature of the data and cluster.
 * <ul>
 * <li><b>Smart Client :</b> smart mode, clients connect to each cluster node. Since each data partition uses the well known and consistent hashing
 * algorithm, each client can send an operation to the relevant cluster node, which increases the overall throughput and efficiency. Smart mode is the
 * default mode.</li>
 * <li><b>Dummy Client :</b> the clients can be required to connect to a single node instead of to each node in the cluster. Firewalls, security, or
 * some custom networking issues can be the reason for these cases. In dummy client mode, the client will only connect to one of the configured
 * addresses. This single node will behave as a gateway to the other nodes. For any operation requested from the client, it will redirect the request
 * to the relevant node and return the response back to the client returned from this node.</li>
 * </ul>
 * 
 * @author ThirupathiReddy V
 */
public class CacheClient {

    public static void main( String[] args ) {

        HazelcastInstance client = HazelcastClient.newHazelcastClient( getJavaClientConfig() );

        // perform some operations
        
        client.getLifecycleService().shutdown();
    }

    public static ClientConfig getJavaClientConfig() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getGroupConfig().setName( "dev" ).setPassword( "dev-pass" );
        clientConfig.getNetworkConfig().addAddress( "localhost" );

        // This Enterprise version only
        // clientConfig.getNetworkConfig().getSocketInterceptorConfig();

        // sets client to dummy client mode. default is smart client mode.(true)
        clientConfig.getNetworkConfig().setSmartRouting( false );
        
        // enables RedoOperation
        /**
         * If true, client will redo the operations that were executing on the server and client lost the connection. This can be because of network, or simply because the member died. However it is not clear whether the application is performed or not. For idempotent operations this is harmless, but for non idempotent ones retrying can cause to undesirable effects. Note that the redo can perform on any member.
         */
        clientConfig.getNetworkConfig().setRedoOperation( true );

        // retry Default value is 2.
        clientConfig.getNetworkConfig().setConnectionAttemptLimit( 5 );

        // Default value is 3000. between each retry
        clientConfig.getNetworkConfig().setConnectionAttemptPeriod( 5000 );

        return clientConfig;
    }

}
