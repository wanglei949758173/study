/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HandlerAdapter.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package test.pattern.structure.adapter.springmvchandleradapter;

public interface HandlerAdapter {
	boolean support(Object handler);

	void hanle(Object handle);
}
