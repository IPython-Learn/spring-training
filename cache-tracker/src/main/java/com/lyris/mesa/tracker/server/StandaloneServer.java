package com.lyris.mesa.tracker.server;

import com.lyris.mesa.tracker.Tracker;

/**
 * This class will creates STANDALONE server instance. in case if all the
 * services goes down. this instance maintains data until they up and running.
 * 
 * @author ThirupathiReddy V
 *
 */
public class StandaloneServer {

	public static void main(String[] args) {
		Tracker.getNodeInstance();

		System.err.println(" ########################################");
		System.err.println("  Hazelcast  Standalone Instance Running ");
		System.err.println(" ########################################");

	}

	/**
	 * configure this as spring bean factory bean
	 */
	public static void startServer() {
		Tracker.getNodeInstance();
	}
}
