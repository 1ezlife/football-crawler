package com.ezlife.manhwacrawler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Chapter {
  private Integer chapterNumber;
  private String url;
  private ZonedDateTime updatedDate;
}
