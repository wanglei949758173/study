/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ExtConfig.java 
 * 作者 王磊 
 * 编写日期 2020年07月26日 
 */
package study.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import study.ioc.bean.Color;

/**
 * Spring扩展
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
@Configuration
@ComponentScan("study.ext")
public class ExtConfig {
	@Bean
	public Color color() {
		return new Color();
	}
}
