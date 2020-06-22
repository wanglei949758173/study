/*      
 * 模块编号  
 * 功能描述 
 * 文件名 IOCTest.java 
 * 作者 王磊 
 * 编写日期 2020年06月14日 
 */
package study.ioc;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.ioc.bean.Dog;
import study.ioc.bean.DogFactoryBean;
import study.ioc.bean.Person;
import study.ioc.config.MainConfig;

public class IOCTest {
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfig.class);
		Person person1 = (Person) applicationContext.getBean("person");
		Person person2 = (Person) applicationContext.getBean("person");
		System.out.println(person1 == person2); // false

		// 获取所有的bean
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName -> {
			System.out.println(beanDefinitionName);
		});

		Dog dog1 = applicationContext.getBean(Dog.class);
		Dog dog2 = applicationContext.getBean(Dog.class);
		System.out.println(dog1 == dog2);// 由FactoryBean的isSingleton()返回值决定

		// 获取FactoryBean
		DogFactoryBean dogFactoryBean =
				(DogFactoryBean) applicationContext.getBean("&dogFactoryBean");
		Dog dog = dogFactoryBean.getObject();
		System.out.println(dog == dog1); // 获取的dog不是spring管理的bean
		applicationContext.close();
	}
}
