package study.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * 测试DefaultListableBeanFactory
 * 
 * @author Administrator
 *
 */
public class TestDefaultListableBeanFactory {
	public static void main(String[] args) {
		// 定义spring配置文件
		// <bean name="person" class="study.spring.Person"></bean>

		// 创建工厂
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 创建resource
		ClassPathResource resource = new ClassPathResource("testDefaultListableBeanFactory.xml");

		// 创建Reader
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

		// 从resource加载BeanDefinition
		reader.loadBeanDefinitions(resource);

		// 获取Bean
		Person person = beanFactory.getBean(Person.class);
		System.out.println(person);
	}

	

}
