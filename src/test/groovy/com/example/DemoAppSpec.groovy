package com.example

import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoAppSpec extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    @LocalServerPort
    int port

    def "exception handling"() {
        when:
        ResponseEntity<String> res = restTemplate.postForEntity("http://localhost:$port/foos", new FooDto(), String.class)
        println res
        println res.body

        def json = new JsonSlurper().parseText(res.body)

        println "json.error = $json.error"

        ErrorDto errorDto = json.error as ErrorDto
        println "errorDto = $errorDto"

        then:
        errorDto.time != null

    }
}
