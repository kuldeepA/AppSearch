package com.fji.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class WriteRecords {

	public static void writeRecords(Map<String, Map<Integer, String>> map) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("C:"+File.separator+"output.txt");
			bw = new BufferedWriter(fw);
			if(map.isEmpty())
				bw.write("No Application Found for Wave !...");
			else{
				
				for (Entry<String, Map<Integer, String>> entry : map.entrySet()) {
				    
				    bw.write("\n\n#####\t"+entry.getKey()+" Application List\t#####\n");
				    
				    for (Map.Entry<Integer, String> nameEntry : entry.getValue().entrySet()) {
				    	Integer key = nameEntry.getKey();
				        String value = nameEntry.getValue();
				        writeToFile(bw,key,value); 
				    }
				}
			}				
			bw.close();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeToFile(BufferedWriter bw, Integer key, String value) throws IOException {
		
		bw.write("\n");
		bw.write(key.toString()+" "+value);
	}
}
