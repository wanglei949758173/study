/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestDispatcherServlet.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package test.pattern.structure.adapter.springmvchandleradapter;

import test.pattern.structure.adapter.springmvchandleradapter.impl.HttpRequestHandler;

public class TestDispatcherServlet {
	public static void main(String[] args) {
		DispatcheServlet dispatcheServelet = new DispatcheServlet();
		dispatcheServelet.doDispatch(new HttpRequestHandler());
	}
}
