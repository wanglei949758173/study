/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TVOffCommand.java 
 * 作者 王磊 
 * 编写日期 2020年05月07日 
 */
package test.pattern.action.command.impl;

import test.pattern.action.command.Command;

public class TVOffCommand implements Command{
	private TVReciver tvReciver;
	
	public TVOffCommand(TVReciver tvReciver) {
		super();
		this.tvReciver = tvReciver;
	}

	@Override
	public void execute() {
		tvReciver.off();
	}

	@Override
	public void undo() {
		tvReciver.on();
	}

}
