/*      
 * 模块编号  
 * 功能描述 
 * 文件名 IOCLifecycleTest.java 
 * 作者 王磊 
 * 编写日期 2020年06月22日 
 */
package study.ioc;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.ioc.config.MainConfigLifecycle;

public class IOCLifecycleTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfigLifecycle.class);

		// 获取所有的bean
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName -> {
			System.out.println(beanDefinitionName);
		});

		applicationContext.close();
	}
}
