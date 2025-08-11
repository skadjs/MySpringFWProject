package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloJunit5Test {

	@Test
	void helloBean() {
		//1. Container 객체 생성
		ApplicationContext context = new GenericXmlApplicationContext("classpath:spring-bean.xml");
	}
}
