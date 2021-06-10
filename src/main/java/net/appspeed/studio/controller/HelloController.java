package net.appspeed.studio.controller;

import lombok.extern.log4j.Log4j2;
import net.appspeed.studio.service.hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
@Log4j2
@RestController
public class HelloController {



	@Autowired
	private hello hh;


	@RequestMapping("/hello")
	public Map<String, Object> index() throws Exception {
		log.info("==================================================");
		log.info("Controller");
		log.info("==================================================");

		return hh.index();
		
	}

}
