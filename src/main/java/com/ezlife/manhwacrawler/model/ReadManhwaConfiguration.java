package com.ezlife.manhwacrawler.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("read-manhwa")
@Setter
@Getter
public class ReadManhwaConfiguration {
  private String baseUrl;
  private String manhwaUrl;
  private List<Manhwa> manhwas;
}
