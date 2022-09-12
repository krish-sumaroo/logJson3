package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectMessage;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;



@RestController
public class HelloController {
	
	private static final Logger logger = LogManager.getLogger(HelloController.class.getName());
	
	//Logger logger = LogManager.getLogger("CONSOLE_JSON_APPENDER");
	
	@GetMapping(path="/log")
	public String helloWorld() {
		
		logger.debug("Debug log message");
		logger.info("Info log message");
		logger.warn("Warning log message");
		logger.error("Error log message");
		logger.fatal("Fatal log message");
		
		return "Hello World";
	}
	
	@GetMapping(path="/detail")
	public String detail() {
		
		HashMap logMap = new HashMap<>();
	    logMap.put("appId", "123456789");
	    logMap.put("action", "Received request");
	
	    logger.info(new ObjectMessage(logMap));
	    
	    return "Hello World Detail";
	}

}
