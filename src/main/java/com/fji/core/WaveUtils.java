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
		//System.out.println(text);
		if (text.trim().length() > 0 && ((text.trim().contains("_QuestionnaireL0new") || text.trim().contains("_QuestionnaireL0") || text.trim().contains("_Questionnaire")))){
			
			if (text.contains("__"))
				values = text.split("__");
			else
				values = text.split("_");
		}System.out.println(values[0]+"  "+values[1]+"  "+values[2]);
		
		if (isNumeric(values[1]))
			return Integer.parseInt(values[1]);
		else
			return Integer.parseInt(values[2]);
	}
	
	 //@Bean
	public static String getValue(String text,String arg) {
		
		return text;
	}
	
	public static boolean isNumeric(String str) {
		try {
			Integer i =Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
