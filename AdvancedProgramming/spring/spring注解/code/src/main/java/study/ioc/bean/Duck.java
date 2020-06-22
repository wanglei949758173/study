/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Duck.java 
 * 作者 王磊 
 * 编写日期 2020年06月22日 
 */
package study.ioc.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Duck {
	public Duck() {
		System.out.println("duck construct");
	}

	@PostConstruct
	private void init() {
		System.out.println("duck init");
	}

	@PreDestroy
	private void destroy() {
		System.out.println("duck destroy");
	}
}
