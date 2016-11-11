package com.example;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TestUtil {
  public static String toString(String path) {
    InputStream in = null;
    try {
      in = TestUtil.class.getClassLoader().getResourceAsStream(path);
      return IOUtils.toString(in, StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      IOUtils.closeQuietly(in);
    }
  }
}
