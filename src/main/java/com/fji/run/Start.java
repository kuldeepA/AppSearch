package com.fji.run;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.fji.browser.Browser;
import com.fji.excel.ReadWaveApp;
import com.fji.read.Read;
import com.fji.write.WriteRecords;
import com.fji.core.FindApplication;

public class Start {
	
	/*public Start() {
		
		try {
			new Read().readApplication();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Browser().openURL();
		
		//bro.openURL();
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//AbstractApplicationContext context = new AnnotationConfigApplicationContext(WaveUtils.class);
		//WaveUtils utils = (WaveUtils) context.getBean("utils");
		
		//Reading all application id and date&time from url
		Browser bro = new Browser();
		Map<Integer, String> urlMap = bro.readURL(bro.openURL());
		
		//below code will read all wave application from updated master data validationxlsx
		ReadWaveApp read = new ReadWaveApp();
		Map<Integer, String> xlsMap = read.readAllApplication();
		/*for (Entry<Integer, String> entry : xlsMap.entrySet()) {
			System.out.println(entry.getKey() +" -- "+entry.getValue());
		}*/
		
		Map<String, Map<Integer, String>> map = new FindApplication().checkExists(urlMap,xlsMap);
		new WriteRecords().writeRecords(map);
		//context.close();
	}
}