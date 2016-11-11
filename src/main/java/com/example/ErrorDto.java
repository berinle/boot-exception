package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDto {
  private String name;

//  private Date time;
  private LocalDateTime time;


  public ErrorDto() { }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /*public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }*/


  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ErrorDto{");
    sb.append("name='").append(name).append('\'');

    sb.append(", time=").append(time);
    sb.append('}');
    return sb.toString();
  }
}
