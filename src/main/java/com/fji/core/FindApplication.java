package com.fji.core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FindApplication {
	
	public static Map<String, Map<Integer, String>> checkExists(Map<Integer, String> urlMap, Map<Integer, String> xlxMap) {
		
		Map<String,Map<Integer,String>> waveMap = new LinkedHashMap<String,Map<Integer,String>>();
		Map<Integer,String> wave1Map = new TreeMap<Integer,String>();
		Map<Integer,String> wave2Map = new TreeMap<Integer,String>();
		Map<Integer,String> wave3Map = new TreeMap<Integer,String>();
		Map<Integer,String> wave4Map = new TreeMap<Integer,String>();
		Map<Integer,String> wave5Map = new TreeMap<Integer,String>();
		Map<Integer,String> ewaveMap = new TreeMap<Integer,String>();
		
		//need to iterate url map and check if key[app id] presnet in xlsmap
		for (Entry<Integer, String> entry : urlMap.entrySet()) {
			
			Integer key = entry.getKey();
			if (xlxMap.containsKey(key)) {
				
				String[] value = xlxMap.get(key).split("-");				
				if (value[0].equals("1.0"))
					wave1Map.put(key, value[1]+" "+urlMap.get(key));
				else if (value[0].equals("2.0"))
					wave2Map.put(key, value[1]+" "+urlMap.get(key));
				else if (value[0].equals("3.0"))
					wave3Map.put(key, value[1]+" "+urlMap.get(key));
				else if (value[0].equals("4.0"))
					wave4Map.put(key, value[1]+" "+urlMap.get(key));
				else if (value[0].equals("5.0"))
					wave5Map.put(key, value[1]+" "+urlMap.get(key));
			} else
				ewaveMap.put(key, "");
		}
		
		waveMap.put("wave1", wave1Map);
		waveMap.put("wave2", wave2Map);
		waveMap.put("wave3", wave3Map);
		waveMap.put("wave4", wave4Map);
		waveMap.put("wave5", wave5Map);
		waveMap.put("wave", ewaveMap);
		
		return waveMap;
	}
}
