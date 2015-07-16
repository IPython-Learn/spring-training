package com.lyris.mesa.tracker;

import org.apache.log4j.Logger;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.MultiMap;

public class TrackerClient extends AbstractTracker {

    /** Reference to logger */
    protected static final Logger logger = Logger.getLogger(TrackerClient.class);

    /** client instance */
    private static HazelcastInstance clientInstance;

    /** disallow creation of direct object instance */
    private TrackerClient() {
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(CLIENT_COFIG));
            // override properties
            overrideConfiguration();
        } catch (Exception e) {
            logger.warn("Error while loading properties from configuration file" + NODE_CONFIG, e);
        }
    }

    /**
     * create client singleton instance only by reading <b>client-config.properties</b> file
     * 
     * @return cache client instance
     */
    public static HazelcastInstance getClientInstance() {

        /** synchronized not allow creation of multiple instance from multiple Thread */
        long start = System.currentTimeMillis();
        synchronized (TrackerClient.class) {

            if (clientInstance == null) {
                logger.info("Creating singleton HazelCast client instance ");
                new TrackerClient();
                /** Loads and merges properties */
                ClientConfig clientConfig = new ClientConfig();
                clientConfig.setProperties(properties);

                // TODO: client side logging only works with system property
                // refer JIRA https://github.com/hazelcast/hazelcast/issues/3103
                System.setProperty("hazelcast.logging.type", "log4j");

                clientInstance = HazelcastClient.newHazelcastClient(clientConfig);
            }
        }

        long diff = System.currentTimeMillis() - start;

        logger.info("Returning client instance " + clientInstance + " in " + diff + " ms.");

        return clientInstance;
    }

    public static IMap<String, Object> getCampaignDocMap() {

        return getClientInstance().getMap(CAMPAIGNDOC_MAP);
    }

    public static IMap<String, Object> getCampaignMap() {

        return getClientInstance().getMap(CAMPAIGN_MAP);
    }

    public static IMap<String, Object> getJobTrackerMap() {

        return getClientInstance().getMap(JOB_TRACKER_MAP);
    }

    public static IMap<String, Object> getContactSetMap() {

        return getClientInstance().getMap(CONTACTSET_MAP);
    }

    public static IMap<String, Object> getScheduleItemMapMap() {

        return getClientInstance().getMap(SCHEDULE_ITEM_MAP);
    }

    public static IMap<String, Object> getMessageContextMap() {
        return getClientInstance().getMap(MEG_CONTEXT_MAP);
    }

    public static IMap<String, Object> getSegmentMap() {
        return getClientInstance().getMap(SEGMENT_MAP);
    }

    public static IMap<String, Object> getConfigSettingsMap() {
        return getClientInstance().getMap(CONFIGURATION_MAP);
    }

    public static MultiMap<String, Object> getJobStatusTrackerMap() {

        return getClientInstance().getMultiMap(JOB_STATUS_TRACKER);
    }

}
