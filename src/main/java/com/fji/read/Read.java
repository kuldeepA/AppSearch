package com.fji.read;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fji.core.Constants;
import com.fji.write.WriteRecords;

public class Read {

	public Map<String, String> readApplication() throws IOException {
		
		Map<String,String> defaultMap = new LinkedHashMap<String,String>();
		//Map<String,String> readMap = new HashMap<String,String>();
		//Map<String, Map<Integer, String>> map = new HashMap<String, Map<Integer, String>>();
		
		File f = new File(Constants.APP_PATH);
		if (!f.exists()) {
		
			defaultMap.put("loginId", "Pls enter Login Id");
			defaultMap.put("password", "Pls enter Password");
			defaultMap.put("fullrecord", "false");
			defaultMap.put("date", "false");
			defaultMap.put("Last Access Record", " default");
			/*defaultMap.put("", "");
			defaultMap.put("", "");
			defaultMap.put("", "");*/
			
			//map.put("Wave", defaultMap);
			FileWriter fw = new FileWriter(Constants.APP_PATH);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Map.Entry<String, String> nameEntry : defaultMap.entrySet()) {
				
				String key = nameEntry.getKey();
				String value = nameEntry.getValue();
				new WriteRecords();
				WriteRecords.writeToFile(bw, key.toString(), value, "=");
			}
			bw.close();
			fw.close();
		} else {
			BufferedReader br = new BufferedReader(new FileReader(Constants.APP_PATH));
			try {		
		    	String line = br.readLine();
		    	while (line != null) {//  line.trim().length() > 0) {
		    		if (line.trim().length() > 0) {
		    			
		    			String val[] = line.trim().split("=");
		    			defaultMap.put(val[0], val[1]);
		    		}
		    		line = br.readLine();
		    	}
			} finally {
		    	br.close();
			}
		}
		return defaultMap;
	}	
}
