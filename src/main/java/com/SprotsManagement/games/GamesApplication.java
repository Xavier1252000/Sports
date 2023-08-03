package com.SprotsManagement.games;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamesApplication {
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}
	static Logger logger = LogManager.getLogger(GamesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GamesApplication.class, args);

		logger.trace("this is trace msg");
		logger.warn("this is warn message");
		logger.debug("this is debug msg");
		logger.info("this is info msg");
		logger.error("this is error msg");
		logger.fatal("this is fatal msg");
	}

}
