
package com.suji.hellocicd;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloCicdApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private String url() {
		return "http://localhost:" + port + "/hello";
	}

	@Test
	void test1StatusCodeIs200() {
		ResponseEntity<String> response =
				restTemplate.getForEntity(url(), String.class);
		assertEquals(200, response.getStatusCode().value());
	}

	@Test
	void test2ResponseIsNotNull() {
		String response = restTemplate.getForObject(url(), String.class);
		assertNotNull(response);
	}

	@Test
	void test3ResponseIsNotEmpty() {
		String response = restTemplate.getForObject(url(), String.class);
		assertFalse(response.isEmpty());
	}

	@Test
	void test4ResponseMatchesExpectedText() {
		String response = restTemplate.getForObject(url(), String.class);
		assertEquals("Hello, CI/CD Pipeeline7", response);
	}

	@Test
	void test5ResponseStartsWithHello() {
		String response = restTemplate.getForObject(url(), String.class);
		assertTrue(response.startsWith("Hello"));
	}

	@Test
	void test6ResponseContainsCICD() {
		String response = restTemplate.getForObject(url(), String.class);
		assertTrue(response.contains("CI/CD"));
	}

	@Test
	void test7ResponseEndsWithSeven() {
		String response = restTemplate.getForObject(url(), String.class);
		assertTrue(response.endsWith("7"));
	}

	@Test
	void test8ResponseHasNoLeadingSpaces() {
		String response = restTemplate.getForObject(url(), String.class);
		assertEquals(response, response.trim());
	}

	@Test
	void test9ResponseHasExpectedLength() {
		String response = restTemplate.getForObject(url(), String.class);
		assertEquals(23, response.length());
	}

	@Test
	void test10RepeatedRequestReturnsSameResponse() {
		String first = restTemplate.getForObject(url(), String.class);
		String second = restTemplate.getForObject(url(), String.class);
		assertEquals(first, second);
	}
}
