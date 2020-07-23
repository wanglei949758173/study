/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TXTest.java  
 * 作者 王磊 
 * 编写日期 2020年7月13日    
 */
package study.tx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.tx.config.MainConfigOfTX;
import study.tx.service.UserService;

public class TXTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfigOfTX.class);
		
		UserService userService = applicationContext.getBean(UserService.class);
		userService.saveUser();
		
		applicationContext.close();
	}
}
