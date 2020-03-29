/*      
 * 模块编号  
 * 功能描述 
 * 文件名 SimpleControllerHandlerAdapter.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package test.pattern.structure.adapter.springmvchandleradapter.impl;

import test.pattern.structure.adapter.springmvchandleradapter.HandlerAdapter;

public class SimpleControllerHandlerAdapter implements HandlerAdapter{

	@Override
	public boolean support(Object handler) {
		return handler instanceof SimpleControllerHandler;
	}

	@Override
	public void hanle(Object handle) {
		System.out.println("handle SimpleControllerHandler");
	}

}
