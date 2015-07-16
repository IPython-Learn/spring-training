package com.lyris.mesa.tracker;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public abstract class AbstractTracker {

	/** Reference to logger */
	protected static final Logger logger = Logger.getLogger(AbstractTracker.class);

	/** node configuration properties */
	protected static final String NODE_CONFIG = "node-config.properties";

	/** client configuration properties */
	protected static final String CLIENT_COFIG = "client-config.properties";

	protected static final String CONFIG_OVERRIDE_FILE = "/etc/lyris/common.properties";

	public static final String JOB_TRACKER_MAP = "jobTracker";
	public static final String JOB_STATUS_TRACKER = "jobStatusTracker";

	
	public static final String CAMPAIGN_MAP = "campaignMap";
	public static final String CAMPAIGNDOC_MAP = "campaignDocMap";
	public static final String CONTACTSET_MAP = "contactSetMap";
	public static final String TMP_QUEUE_TRACKER = "tmpQueueTracker";

	public static final String SCHEDULE_ITEM_MAP = "scheduleItemMap";
	public static final String MEG_CONTEXT_MAP = "messageContextMap";
	public static final String SEGMENT_MAP = "segmentMap";

	public static final String CONFIGURATION_MAP = "configurationSettingsMap";
	
	/** reference to properties */
	protected static Properties properties = new Properties();

	protected void overrideConfiguration() {

		try {
			properties.load(new FileInputStream(CONFIG_OVERRIDE_FILE));
			if (logger.isDebugEnabled()) {
				logger.debug("Properties loaded successfully from the file "
						+ CONFIG_OVERRIDE_FILE);
			}
		} catch (Exception e) {
			logger.warn("error while loading file " + CONFIG_OVERRIDE_FILE, e);
		}
	}

}
