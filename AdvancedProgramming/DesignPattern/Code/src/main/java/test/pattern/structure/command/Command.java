/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Command.java 
 * 作者 王磊 
 * 编写日期 2020年05月07日 
 */
package test.pattern.structure.command;

public interface Command {
	void execute();

	void undo();
}
