package xyz.marsj.spring.name;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class NameTest {
	private Name name;
	public NameTest() {
		Resource res=new ClassPathResource("xyz/marsj/name/name.xml");
		BeanFactory beanfactory=new XmlBeanFactory(res);
		name = beanfactory.getBean("name", Name.class);
	}
	
	@Test
	public void test(){
		 name.syso();
	}
	


}
