/*      
 * 模块编号  
 * 功能描述 
 * 文件名 LightOffCommand.java 
 * 作者 王磊 
 * 编写日期 2020年05月07日 
 */
package test.pattern.action.command.impl;

import test.pattern.action.command.Command;

public class LightOffCommand implements Command{
	/**
	 * 命令接受者,真正执行命令的人
	 */
	private LightReciver lightReciver;
	
	public LightOffCommand(LightReciver lightReciver) {
		super();
		this.lightReciver = lightReciver;
	}

	@Override
	public void execute() {
		lightReciver.off();
	}

	@Override
	public void undo() {
		lightReciver.on();
	}

}