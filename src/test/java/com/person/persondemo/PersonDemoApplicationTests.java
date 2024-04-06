// Jai Swaminarayan KESHAV , Swami-Shreeji
package com.person.persondemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
@SpringBootTest
class PersonDemoApplicationTests {

	private Calculator c = new Calculator();

	@Test
	void contextLoads() {
	}

	@Test
	void testSum(){
		// expectedResult
		int expectedResult = 7+13+20;
		// actualResult
		int actualResult = c.doSum(7,13,20);

		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void testProduct(){
		int expectedResult = 6;
		int actualResult = c.doProduct(3,2);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	void testCompares(){
		boolean actualResult = c.compares(7, 7);
		assertThat(actualResult).isTrue();
	}
}
