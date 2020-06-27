/*      
 * 模块编号  
 * 功能描述 
 * 文件名 IOCAutowireTest.java 
 * 作者 王磊 
 * 编写日期 2020年06月27日 
 */
package study.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.ioc.config.MainConfigOfAutowire;

public class IOCAutowireTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfigOfAutowire.class);

		applicationContext.close();
	}
}
