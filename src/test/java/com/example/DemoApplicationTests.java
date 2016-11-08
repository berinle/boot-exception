package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Map> map = mapper.readValue(entity.getBody(), Map.class);
		ErrorDto errorDto = mapper.readValue(mapper.writeValueAsString(map.get("error")), ErrorDto.class);
		System.out.println("errorDto = " + errorDto);
		System.out.println("entity = " + entity);
	}


	@JsonIgnoreProperties(ignoreUnknown = true)
	class Wrapper {
		public Wrapper() { }

		private ErrorDto error;

		public ErrorDto getError() {
			return error;
		}

		public void setError(ErrorDto error) {
			this.error = error;
		}
	}

}
