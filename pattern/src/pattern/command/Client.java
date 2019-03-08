/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.command;

import pattern.command.command.Command;
import pattern.command.command.impl.ConcreteCommand;
import pattern.command.invoker.Invoker;
import pattern.command.reciver.Reciver;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		Reciver reciver = new Reciver();
		Command command = new ConcreteCommand(reciver);
		
		Invoker invoker = new Invoker(command);
		invoker.runCommand();
	}
}
