package com.testHelloWorld.HelloWorld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.helloworld.service.BusinessService;

@SpringBootTest
class HelloWorldApplicationTests {

	@Autowired
	private BusinessService bs;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetHelloWorld(){
		String expedted = "Hello World";
		String result = bs.getHelloWorld().getValue();

		assertEquals(expedted, result);
	}
}
