/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MainConfig.java 
 * 作者 王磊 
 * 编写日期 2020年06月14日 
 */
package study.ioc.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import study.ioc.bean.Person;

@Configuration
@ComponentScan(value = "study.ioc",
		includeFilters = { @Filter(type = FilterType.ANNOTATION, classes = { Controller.class }), },
		useDefaultFilters = false)
public class MainConfig {
	@Lazy
//	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("spring bean");
		person.setAge(20);
		person.setNickName("豆子");
		return person;
	}
}
