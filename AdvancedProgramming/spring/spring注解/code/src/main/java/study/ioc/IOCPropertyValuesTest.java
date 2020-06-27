/*      
 * 模块编号  
 * 功能描述 
 * 文件名 IOCPropertyValuesTest.java 
 * 作者 王磊 
 * 编写日期 2020年06月27日 
 */
package study.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.ioc.bean.Person;
import study.ioc.config.MainConfigOfPropertyValues;

public class IOCPropertyValuesTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

		Person person = applicationContext.getBean(Person.class);
		System.out.println(person);
		
		applicationContext.close();
	}
}
