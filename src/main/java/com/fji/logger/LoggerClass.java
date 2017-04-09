package com.fji.logger;

import org.apache.log4j.Logger;

public class LoggerClass {

	private static final Logger logger = Logger.getLogger(LoggerClass.class.getName());
	
	public void printLoggerInfo(Object className, Exception msg) {
		
		logger.info(className +" : " + msg.getMessage());
	}
	
	public void printLoggerError(Object className, Exception msg) {
		
		logger.error(className, msg.getCause());
	}
}
