package com.ezlife.manhwacrawler.scheduler;

import java.text.SimpleDateFormat;

import com.ezlife.manhwacrawler.crawler.ReadManhwaCrawler;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class ScheduledTasks {

  private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  private final ReadManhwaCrawler crawler;

  @Autowired
  public ScheduledTasks(ReadManhwaCrawler crawler) {
    this.crawler = crawler;
  }

  @Scheduled(cron = "0 * * * * *")
  public void reportCurrentTime() {
    crawler.getManhwas();
  }
}
