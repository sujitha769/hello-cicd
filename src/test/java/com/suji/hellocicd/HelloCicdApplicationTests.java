
package com.suji.hellocicd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloCicdApplicationTests {

	@Test
	void helloReturnsExpectedMessage() {
		HelloController controller = new HelloController();

		String response = controller.hello();

		assertEquals("Hello, CI/CD Pipeeline", response);
	}
}
