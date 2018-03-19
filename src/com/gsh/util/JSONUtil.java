package com.gsh.util;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class JSONUtil {
	public static String getUserJsonMap(Map map){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"cities","userRoles","province"});
		//jsonConfig.setCycleDetectionStrategy()
		JSONArray jsonArray = JSONArray.fromObject(map, jsonConfig);
		String r = jsonArray.toString();
		r=r.subSequence(1, r.length()-1).toString();
		return r ;
	}
}
