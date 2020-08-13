package com.ezlife.footballcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FootballCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballCrawlerApplication.class, args);
	}

}
