/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PhoneService.java 
 * 作者 王磊 
 * 编写日期 2020年03月31日 
 */
package test.pattern.structure.bridge;

public interface PhoneFunction {
	void open();

	void close();

	void call();
}
