/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MainConfigOfAutowire.java 
 * 作者 王磊 
 * 编写日期 2020年06月27日 
 */
package study.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import study.ioc.bean.Dog;

@Configuration
public class MainConfigOfAutowire {
	@Bean
	public Dog dog() {
		return new Dog();
	}
}
