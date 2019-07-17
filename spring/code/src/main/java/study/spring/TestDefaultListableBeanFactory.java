package study.spring;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.BeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
