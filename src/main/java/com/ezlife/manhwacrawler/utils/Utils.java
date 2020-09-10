package com.ezlife.manhwacrawler.utils;

import com.ezlife.manhwacrawler.model.Chapter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Map;

public class Utils {
  private static Map<String, TemporalUnit> dateMap = Map.ofEntries(
      Map.entry(" hours ago", ChronoUnit.HOURS),
      Map.entry(" hour ago", ChronoUnit.HOURS),
      Map.entry(" days ago", ChronoUnit.DAYS),
      Map.entry(" day ago", ChronoUnit.DAYS)
  );
  public static Chapter getChapter(WebElement chapterElement) {
    WebElement updatedDate = chapterElement.findElement(new By.ByTagName("span"));
    String chapterStr = chapterElement.getAttribute("innerText").split("\n")[0];

    return new Chapter(
        Integer.valueOf(chapterStr.split(" ")[1]),
        chapterElement.getAttribute("href"),
        Utils.getUpdatedDate(updatedDate.getAttribute("innerText"))
    );
  }

  public static ZonedDateTime getUpdatedDate(String updatedStr) {
    for (Map.Entry<String, TemporalUnit> entry : dateMap.entrySet()) {
      if (updatedStr.endsWith(entry.getKey())) {
        Integer num = Integer.valueOf(updatedStr.substring(0, updatedStr.length() - entry.getKey().length()));
        return ZonedDateTime.now().minus(num, entry.getValue());
      }
    }
    return LocalDate
        .parse(new StringBuilder(updatedStr))
        .atStartOfDay(ZoneId.systemDefault());
  }
}
