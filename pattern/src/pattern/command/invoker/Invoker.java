/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Invoker.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.command.invoker;
/**
 * Invoker
 * 
 * @version 
 * @author 王磊
 */

import pattern.command.command.Command;
/**
 * Invoker
 * 
 * @version 
 * @author 王磊
 */
public class Invoker {
	private Command command;
	
	public void runCommand() {
		command.execute();
	}

	public Invoker(Command command) {
		this.command = command;
	}
	
}
