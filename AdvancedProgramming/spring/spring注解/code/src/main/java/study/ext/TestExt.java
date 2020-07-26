/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestExt.java 
 * 作者 王磊 
 * 编写日期 2020年07月26日 
 */
package study.ext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestExt {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ExtConfig.class);
		
		applicationContext.close();
	}
}
