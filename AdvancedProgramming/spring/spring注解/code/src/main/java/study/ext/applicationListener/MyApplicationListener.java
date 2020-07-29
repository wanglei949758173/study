/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MyApplicationListener.java 
 * 作者 王磊 
 * 编写日期 2020年07月28日 
 */
package study.ext.applicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.toString());
	}

}
