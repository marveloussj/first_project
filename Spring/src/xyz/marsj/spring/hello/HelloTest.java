package xyz.marsj.spring.hello;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloTest {
private IHelloSpring helloSpring;
public HelloTest() {
	Resource resource=new ClassPathResource("applicationContext.xml");
	BeanFactory beanFactory =new XmlBeanFactory(resource);
	helloSpring=beanFactory.getBean("helloWord", IHelloSpring.class);
}
@Test
public void test(){
	helloSpring.sayHello();
}
}
