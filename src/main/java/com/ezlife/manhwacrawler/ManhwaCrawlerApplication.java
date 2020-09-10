package com.ezlife.manhwacrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ManhwaCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManhwaCrawlerApplication.class, args);
	}

}
