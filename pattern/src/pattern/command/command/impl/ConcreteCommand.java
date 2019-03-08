/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteCommand.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.command.command.impl;

import pattern.command.command.Command;
import pattern.command.reciver.Reciver;

/**
 * 命令实现
 * 
 * @version 
 * @author 王磊
 */
public class ConcreteCommand implements Command {

	private Reciver reciver;
	
	@Override
	public void execute() {
		reciver.handle();
	}

	public ConcreteCommand(Reciver reciver) {
		this.reciver = reciver;
	}

}
