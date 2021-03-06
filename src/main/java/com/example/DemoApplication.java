package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

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

@ControllerAdvice
class GlobalExceptionHandler {
	@ExceptionHandler({ FooException.class })
	public ResponseEntity<?> handleException() {
		HashMap<String, ErrorDto> map = new HashMap<>();
		ErrorDto dto = new ErrorDto();
		dto.setName("foo-bar");
		dto.setTime(new Date());
//		dto.setTime(LocalDateTime.now());
		map.put("error", dto);

		return ResponseEntity.badRequest().body(map);
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class FooDto {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

//@ResponseStatus(HttpStatus.BAD_REQUEST)
class FooException extends RuntimeException {
	public FooException(String message) {
		super(message);
	}
}


