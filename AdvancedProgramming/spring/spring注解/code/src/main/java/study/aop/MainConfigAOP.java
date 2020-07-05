/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MainConfigAOP.java 
 * 作者 王磊 
 * 编写日期 2020年07月05日 
 */
package study.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import study.aop.aspect.LogAspect;
import study.aop.service.MathCalculator;

@Configuration
@EnableAspectJAutoProxy
public class MainConfigAOP {
	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}

	@Bean
	public LogAspect logAspect() {
		return new LogAspect();
	}
}
