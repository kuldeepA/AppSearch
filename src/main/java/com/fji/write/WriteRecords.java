package com.fji.write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.fji.core.Constants;

public class WriteRecords {

	public static void writeRecords(Map<String, Map<Integer, String>> map) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(Constants.APP_OUTPUT_FILE);
			bw = new BufferedWriter(fw);
			if(map.isEmpty())
				bw.write("No Application Found for Wave !...");
			else if (map.containsKey("Wave")) {
				
			}
			else{
				
				for (Entry<String, Map<Integer, String>> entry : map.entrySet()) {
				    
					Integer count = 0;
				    bw.write("\n\n#####\t"+entry.getKey()+" Application List\t#####\n");
				    
				    for (Map.Entry<Integer, String> nameEntry : entry.getValue().entrySet()) {
				    	count  = entry.getValue().entrySet().size();
				    	Integer key = nameEntry.getKey();
				        String value = nameEntry.getValue();
				        writeToFile(bw,key.toString(),value," "); 
				    }
				    writeToFile(bw,"\nTotal "+entry.getKey()+" Count",count.toString()," "); 
				}
			}				
			bw.close();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToFile(BufferedWriter bw, String key, String value, String delimeter) throws IOException {
		
		bw.write("\n");
		bw.write(key+delimeter+value);
	}
	
	public static void replace(String newRecord, Map<String,String> defaultMap) {

		//BufferedReader br = null;
		BufferedWriter tmp = null;
		FileWriter fw = null;
		String oldRecord = null;
		try {
			defaultMap.put("Last Access Record", newRecord);
			//br = new BufferedReader(new FileReader(Constants.APP_PATH));
			fw = new FileWriter(Constants.TMP_PATH);
			tmp = new BufferedWriter(fw);
			//FileWriter fw = new FileWriter(Constants.APP_PATH);
			//BufferedWriter bw = new BufferedWriter(fw);
			for (Map.Entry<String, String> nameEntry : defaultMap.entrySet()) {
				
				String key = nameEntry.getKey();
				String value = nameEntry.getValue();
				new WriteRecords();
				WriteRecords.writeToFile(tmp, key.toString(), value, "=");
			}
			tmp.close();
			fw.close();
			
		} catch (Exception e) {
			//return;
		} 
		// Once everything is complete, delete old file..
		File oldFile = new File(Constants.APP_PATH);
		oldFile.delete();

		// And rename tmp file's name to old file name
		File newFile = new File(Constants.TMP_PATH);
		newFile.renameTo(oldFile);

	}
}
