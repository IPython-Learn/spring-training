package com.lyris.mesa.sync;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SyncUtils {
	
	/**
	 * Correlate incoming REST call with an internal sync operation.
	 */
	public static enum Operation {

    	POST_SAVE("", "save"),
    	PUT_SAVE("save", "save"), PUT_START("start", "start"), PUT_STOP("stop", "stop"), 
    	//GET_SUMMARY("summary", "getSummary"), GET_LOGS("logs", "getLogs"), GET_STATUS("status", "getStatus"), GET_CONFIG("", "getConfig"), GET_MODULES("", "getModules"),
    	DELETE_CONFIG("", "deleteConfig"), //DELETE_STATUS("status", "deleteStatus"),
    	GET("", "get");
        
		private final String urlOperation;
		private final String syncOperation;
		private static Map<String, Operation> constants = new HashMap<String, Operation>();

		static {
			for (Operation c : Operation.values()) {
				if (c.urlOperation.equals(""))
					continue;
				constants.put(c.urlOperation, c);
			}
		}

		private Operation(String urlOperation, String syncOperation) {
			this.urlOperation = urlOperation;
			this.syncOperation = syncOperation;
		}

		public String getUrlOperation() {
			return this.urlOperation;
		}

		public String getSyncOperation() {
			return this.syncOperation;
		}

		public static Operation fromValue(String urlOperation) {
			Operation constant = constants.get(urlOperation);
			if (constant == null) {
				throw new IllegalArgumentException("Unknown operation: "
						+ urlOperation);
			} else {
				return constant;
			}
		}
	}
	
    /**
	 * Generate sync job id with normalized orgName
	 * 
	 * @param orgName
	 * @param source
	 * @param target
	 * @return
	 */
	public static String generateSyncId(String orgName, String source, String target) {
		return SyncConstants.SYNC + "." + normalizeOrgName(orgName) + "." + source + "." + target;
	}
	
	/**
	 * Normalize orgName by url encoding the variable
	 * 
	 * @param orgName
	 * @return
	 */
	public static String normalizeOrgName(String orgName) {
		try {
			return URLEncoder.encode(orgName, "UTF-8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException uee) {
			//this should never happen, don't want to throw any exceptions for now
			return "FailedToEncodeOrgName";
		}
	}
	
	public static String normalizeName(String name) {
		if(name == null) {
			return "";
		}
		else
			return name.trim().replaceAll("[^0-9,a-z,A-Z,_]", "_");
	}

}
