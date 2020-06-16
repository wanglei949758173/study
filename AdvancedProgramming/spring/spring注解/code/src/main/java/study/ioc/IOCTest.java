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

import study.ioc.bean.Person;
import study.ioc.config.MainConfig;

public class IOCTest {
	public static void main(String[] args) {
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
		applicationContext.close();
	}
}
