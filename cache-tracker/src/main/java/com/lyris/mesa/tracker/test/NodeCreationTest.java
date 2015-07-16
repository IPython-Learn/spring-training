package com.lyris.mesa.tracker.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lyris.mesa.tracker.Tracker;

/**
 * This class will test number of node instance gets create if multiple threads accessing in the same machine
 * 
 * @author ThirupathiReddy V
 *
 */
public class NodeCreationTest {

    public static final int THREAD_COUNT = 1;// increase this count to check
                                             // Thread safety

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable serverThread = new Runnable() {

            @Override
            public void run() {

                Tracker.getCampaignDocMap().put("FIVE", "5");

                long start = System.currentTimeMillis();
                Object a = Tracker.getCampaignDocMap().get("FIVE");
                long diff = System.currentTimeMillis() - start;

                System.out.println("difference :  " + diff + "  a =" + a);
                System.err.println("########");
                start = System.currentTimeMillis();
                a = Tracker.getCampaignDocMap().get("THREE");
                diff = System.currentTimeMillis() - start;

                System.out.println("difference :  " + diff + "  a =" + a);

               // Tracker.shutdown();

            }
        };

        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.execute(serverThread);
        }

        executorService.shutdown();

    }
}
