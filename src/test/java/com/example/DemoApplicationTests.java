package com.example;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;

	@Test
	public void exceptionHandling() throws IOException {
		ResponseEntity<String> entity = template.postForEntity("http://localhost:" + port + "/foos", new FooDto(), String.class);
		System.out.println("entity = " + entity);

		Map map = JSON.parseObject(entity.getBody(), Map.class);
		ErrorDto _dto = JSON.parseObject(JSON.toJSONString(map.get("error")), ErrorDto.class);
		System.out.println("_dto = " + _dto);

		assertThat(_dto.getName()).isNotNull();
		assertThat(_dto.getTime()).isNotNull();
	}
}
