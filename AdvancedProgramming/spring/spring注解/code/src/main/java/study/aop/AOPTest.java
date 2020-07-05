/*      
 * 模块编号  
 * 功能描述 
 * 文件名 AOPTest.java 
 * 作者 王磊 
 * 编写日期 2020年07月05日 
 */
package study.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.aop.service.MathCalculator;

public class AOPTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfigAOP.class);

		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

		mathCalculator.div(6, 0);

		applicationContext.close();
	}
}
