/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MainConfigOfPropertyValues.java 
 * 作者 王磊 
 * 编写日期 2020年06月27日 
 */
package study.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import study.ioc.bean.Person;

@Configuration
@PropertySource("classpath:person.properties")
public class MainConfigOfPropertyValues {
	@Bean
	public Person person() {
		return new Person();
	}
}
