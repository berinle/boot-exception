package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@Controller
class FooController {
	@PostMapping(value = "/foos")
	private ResponseEntity<?> create(@RequestBody FooDto fooDto) {
		throw new FooException("test");
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class FooDto {
	private String name;

	public FooDto() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class FooException extends RuntimeException {
	public FooException(String message) {
		super(message);
	}
}


