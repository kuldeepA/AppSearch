package com.fji.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration//(value="utils")
//@ComponentScan("com.fji.browser")
public class WaveUtils {

	//@Bean
	public static int getIntValue(String text) {
		
		String[] values = null;
		if (text.trim().length() > 0 && ((text.trim().endsWith("_QuestionnaireL0new") || text.trim().endsWith("_QuestionnaireL0")))){
			
			values = text.split("__");
		}
		return Integer.parseInt(values[1]);
	}
	
	 //@Bean
	public static String getValue(String text,String arg) {
		
		return text;
	}
}
