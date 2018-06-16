package myspring.di.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanSpringTest {
	// 설정정보(ContextConfiguration)에서 주입 받겠다는 것을 의미
	@Autowired
	ApplicationContext context;
	
	// junit에서 제공
	@Test
	public void bean1() {
		Hello hello = (Hello)context.getBean("hello");
		
		assertEquals("Hello Jonghui", hello.sayHello());
		
		hello.print();
	}
}
