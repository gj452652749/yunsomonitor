package com.monitor.util;

public class CoreUrlGenerator {
	final static String MODULE_URL="http://localhost:8090/solr/core1/";
	public static String generateCoreUrl(String userName,String coreName) {
		String core=userName+"_"+coreName;
		String url=MODULE_URL.replace("core1", core);
		return url;
	}
	public static String generateDihStatusUrl(String userName,String coreName,
			String dsName,String tbName) {
		String url=generateCoreUrl(userName,coreName)+
				"dataimport?command=status&indent=true&wt=json";
		return url;
	}
}
