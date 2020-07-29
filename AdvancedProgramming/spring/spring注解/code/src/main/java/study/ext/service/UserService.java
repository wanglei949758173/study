/*      
 * 模块编号  
 * 功能描述 
 * 文件名 UserService.java 
 * 作者 王磊 
 * 编写日期 2020年07月29日 
 */
package study.ext.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@EventListener(classes = { ApplicationEvent.class })
	public void listening(ApplicationEvent event) {
		System.out.println("UserService " + event);
	}
}
