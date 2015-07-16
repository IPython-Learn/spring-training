package com.lyris.mesa.tracker.test;

import com.lyris.mesa.tracker.TrackerClient;

/**
 * This class will test number of client instances.
 * 
 * @author ThirupathiReddy V
 *
 */
public class ClientCreationTest {

    public static final int THREAD_COUNT = 1;

    public static void main(String[] args) {
        TrackerClient.getCampaignDocMap().clear();

        // TrackerClient.getCampaignDocMap().put("ONE", "");
        // TrackerClient.getCampaignDocMap().put("TWO", "");

    }
}
