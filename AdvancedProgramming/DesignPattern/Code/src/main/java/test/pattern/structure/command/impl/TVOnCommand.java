/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TVOnCommand.java 
 * 作者 王磊 
 * 编写日期 2020年05月07日 
 */
package test.pattern.structure.command.impl;

import test.pattern.structure.command.Command;

public class TVOnCommand implements Command{
	private TVReciver tvReciver;
		
	public TVOnCommand(TVReciver tvReciver) {
		super();
		this.tvReciver = tvReciver;
	}

	@Override
	public void execute() {
		tvReciver.on();
	}

	@Override
	public void undo() {
		tvReciver.off();
	}

}
