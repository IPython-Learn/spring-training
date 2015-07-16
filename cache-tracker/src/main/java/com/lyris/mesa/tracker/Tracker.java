package com.lyris.mesa.tracker;

import java.util.Map;

import org.apache.log4j.Logger;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.MultiMap;
import com.hazelcast.core.PartitionService;
import com.lyris.mesa.message.MessageContext;
import com.lyris.mesa.model.campaign.ScheduleItem;

/**
 * This is the core utility class which exposes two static methods.
 * <ul>
 * <li><b>getNodeInstance :</b> which creates new node per service by which it invokes.</li>
 * <li><b>getClientInstance : </b>it create client instance only and doesn't create new node</li>
 * </ul>
 * 
 * @author ThirupathiReddy V
 *
 */
public class Tracker extends AbstractTracker {

    /** Reference to logger */
    protected static final Logger logger = Logger.getLogger(Tracker.class);

    /** Creates node and returns */
    private static HazelcastInstance nodeInstance;

    /** disallow creation of direct object instance */
    private Tracker() {
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(NODE_CONFIG));
            // override properties
            overrideConfiguration();
        } catch (Exception e) {
            logger.warn("Error while loading properties from configuration file" + NODE_CONFIG, e);
        }
    }

    /**
     * This method creates and return new node singleton instance. but it is restricted to one instance per machine (from where this class invoked). It reads
     * <b>node-config.properties</b>
     * 
     * @return instance
     */
    public static HazelcastInstance getNodeInstance() {

        /** synchronized not allow creation of multiple instance from multiple Thread */
        long start = System.currentTimeMillis();
        synchronized (Tracker.class) {
            if (nodeInstance == null) {
                logger.info("Creating  Hazelcast singleton instance ");
                new Tracker();
                // fill the properties, e.g. from database/ldap etc
                XmlConfigBuilder builder = new XmlConfigBuilder();
                builder.setProperties(properties);
                Config config = builder.build();
                nodeInstance = Hazelcast.newHazelcastInstance(config);
            }
        }

        long diff = System.currentTimeMillis() - start;
        logger.info("Returning node instance " + nodeInstance + " in " + diff + " ms.");

        return nodeInstance;
    }

    public static void shutdown() {
        logger.info("Received  shutdown call on the node " + getNodeInstance());
        PartitionService partitionService = getNodeInstance().getPartitionService();

        logger.info("Is partitionService localMemberSafe to shutdown ? : " + partitionService.isLocalMemberSafe());

        if (partitionService.isLocalMemberSafe()) {
            getNodeInstance().shutdown();
        }
        
        
        
        logger.info("Is partitionService clusterSafe to shutdown ? : " + partitionService.isClusterSafe());

        if (partitionService.isClusterSafe()) {
            getNodeInstance().shutdown();
        }

    }

    public static IMap<String, String> getCampaignDocMap() {

        return getNodeInstance().getMap(CAMPAIGNDOC_MAP);
    }

    public static IMap<String, String> getCampaignMap() {

        return getNodeInstance().getMap(CAMPAIGN_MAP);
    }

    public static IMap<String, Object> getJobTrackerMap() {

        return getNodeInstance().getMap(JOB_TRACKER_MAP);
    }

    public static IMap<String, String> getContactSetMap() {

        return getNodeInstance().getMap(CONTACTSET_MAP);
    }

    public static IMap<String, ScheduleItem> getScheduleItemMapMap() {

        return getNodeInstance().getMap(SCHEDULE_ITEM_MAP);
    }

    public static IMap<String, MessageContext> getMessageContextMap() {
        return getNodeInstance().getMap(MEG_CONTEXT_MAP);
    }

    public static IMap<String, Object> getSegmentMap() {
        return getNodeInstance().getMap(SEGMENT_MAP);
    }

    public static IMap<String, Map<String, String>> getConfigSettingsMap() {
        return getNodeInstance().getMap(CONFIGURATION_MAP);
    }

    public static MultiMap<String, Object> getJobStatusTrackerMap() {

        return getNodeInstance().getMultiMap(JOB_STATUS_TRACKER);
    }
}
