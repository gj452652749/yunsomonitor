package com.monitor.util;

import net.sf.json.JSONObject;

public class CoreResponseParser {
	/**
	 * 
	 * @param json
	 * @return {"totalRowsFetched":"40","speed":"20"}
	 */
	public static String parseStatus(String json) {
		JSONObject result=new JSONObject();
		JSONObject jsonObj=JSONObject.fromObject(json);
		JSONObject statusMessages=jsonObj.getJSONObject("statusMessages");
		String totalRowsFetched=statusMessages.getString("Total Rows Fetched");
		String timeTaken=statusMessages.getString("Time taken");
		System.out.println(totalRowsFetched+timeTaken);
		String[] timeToken=timeTaken.split(":");
		int h=Integer.parseInt(timeToken[0]);
		int m=Integer.parseInt(timeToken[1]);
		int s=Integer.parseInt(timeToken[2]);
		int totalRows=Integer.parseInt(totalRowsFetched);
		int seconds=h*3600+m*60+s;
		int speed=totalRows/seconds;
		result.put("totalRowsFetched", totalRowsFetched);
		result.put("speed", String.valueOf(speed));
		return result.toString();
	}
}
