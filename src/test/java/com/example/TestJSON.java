package com.example;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class TestJSON {

  @Test
  public void name() throws Exception {
    String json = TestUtil.toString("hello.json");
    System.out.println("json = " + json);
    ErrorDto errorDto = JSON.parseObject(json, ErrorDto.class);
    System.out.println("errorDto = " + errorDto);
  }

  @Test
  public void name_2() throws Exception {
    String json = TestUtil.toString("hello.json");
    System.out.println("json = " + json);
    Map map = JSON.parseObject(json, Map.class);
    ErrorDto errorDto = JSON.parseObject(JSON.toJSONString(map.get("error")), ErrorDto.class);
    System.out.println("errorDto = " + errorDto);
  }

  @Test
  @Ignore
  public void jacksonMapper() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);

    String json = new String(Files.readAllBytes(Paths.get("/private/tmp/boot-exception/src/test/java/com/example/hello.json")));
    System.out.println("json = " + json);

    ErrorDto errorDto = mapper.readValue(json, ErrorDto.class);
    System.out.println("errorDto = " + errorDto);

  }
}


