/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestExt.java 
 * 作者 王磊 
 * 编写日期 2020年07月26日 
 */
package study.ext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.ext.event.MyEvent;

public class TestExt {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ExtConfig.class);
		
		// 发布事件
		applicationContext.publishEvent(new MyEvent());
		
		applicationContext.close();
	}
}
