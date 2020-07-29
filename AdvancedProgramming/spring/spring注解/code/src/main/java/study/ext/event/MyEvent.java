/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MyEvent.java 
 * 作者 王磊 
 * 编写日期 2020年07月29日 
 */
package study.ext.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

	public MyEvent() {
		super("My Event");
	}

	private static final long serialVersionUID = 1L;

}
