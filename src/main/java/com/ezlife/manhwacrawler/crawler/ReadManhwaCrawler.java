package com.ezlife.manhwacrawler.crawler;

import com.ezlife.manhwacrawler.model.ReadManhwaConfiguration;
import com.ezlife.manhwacrawler.model.Manhwa;
import com.ezlife.manhwacrawler.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReadManhwaCrawler {
  private ReadManhwaConfiguration config;

  @Autowired
  public ReadManhwaCrawler(ReadManhwaConfiguration config) {
    this.config = config;
  }

  public void getManhwas() {
    for (Manhwa manhwa : config.getManhwas()) {
      getManhwa(manhwa);
    }
  }

  private void getManhwa(Manhwa manhwa) {
    String url = config.getBaseUrl() + config.getManhwaUrl() + manhwa.getCode();
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    WebDriver driver = new ChromeDriver(options);
    driver.get(url);
    WebElement chaptersDiv = driver.findElement(new By.ByClassName("comic-chapters"));
    List<WebElement> chapters = chaptersDiv.findElements(new By.ByClassName("comic-chapter"));

    chapters.stream().map(chapter -> Utils.getChapter(chapter)).forEach(System.out::println);

    // Close driver
    driver.quit();
  }
}
