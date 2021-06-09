package net.appspeed.studio.controller;

import net.appspeed.studio.service.hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
	public static final Logger logger = LogManager.getLogger(HelloController.class);


	@Autowired
	private hello hh;


	@RequestMapping("/hello")
	public Map<String, Object> index() {
		logger.info("==================================================");
		logger.info("Controller");
		logger.info("==================================================");

		return hh.index();
		
	}

}
