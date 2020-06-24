/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MainConfigLifecycle.java 
 * 作者 王磊 
 * 编写日期 2020年06月22日 
 */
package study.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import study.ioc.bean.Car;
import study.ioc.bean.Cat;
import study.ioc.bean.Duck;
import study.ioc.bean.MyBeanPostProcessor;

@Configuration
public class MainConfigLifecycle {
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Car car() {
		return new Car();
	}

	@Bean
	public Cat cat() {
		return new Cat();
	}

	@Bean
	public Duck duck() {
		return new Duck();
	}

	@Bean
	public MyBeanPostProcessor myBeanPostProcessor() {
		return new MyBeanPostProcessor();
	}
}
