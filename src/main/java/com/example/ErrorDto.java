package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDto {
  private String name;

//  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  private Date time;

  public ErrorDto() { }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
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
