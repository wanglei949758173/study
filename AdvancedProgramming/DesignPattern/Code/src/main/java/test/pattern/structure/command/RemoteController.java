/*      
 * 模块编号  
 * 功能描述 
 * 文件名 RemoteController.java 
 * 作者 王磊 
 * 编写日期 2020年05月07日 
 */
package test.pattern.structure.command;

import test.pattern.structure.command.impl.NoCommand;

public class RemoteController {
	/**
	 * 开命令
	 */
	private Command[] onCommands;

	/**
	 * 关命令
	 */
	private Command[] offCommands;

	/**
	 * 撤销命令
	 */
	private Command undoCommand;

	public RemoteController() {
		// 初始化为空命令
		onCommands = new Command[5];
		offCommands = new Command[5];
		for (int i = 0; i < 5; i++) {
			onCommands[i] = new NoCommand();
			offCommands[i] = new NoCommand();
		}
	}

	/**
	 * 设置命令
	 * @param no				编号
	 * @param onCommand			开命令
	 * @param offCommand		关命令
	 */
	public void setCommand(int no, Command onCommand, Command offCommand) {
		onCommands[no] = onCommand;
		offCommands[no] = offCommand;
	}

	/**
	 * 按下按钮no
	 * @param no	按钮编号
	 */
	public void onButtonWasPushed(int no) { // no 0
		// 找到你按下的开的按钮， 并调用对应方法
		onCommands[no].execute();
		// 记录这次的操作，用于撤销
		undoCommand = onCommands[no];

	}

	/**
	 * 按下关闭按钮no
	 * @param no	按钮编号
	 */
	public void offButtonWasPushed(int no) { // no 0
		// 找到你按下的关的按钮， 并调用对应方法
		offCommands[no].execute();
		// 记录这次的操作，用于撤销
		undoCommand = offCommands[no];

	}

	/**
	 * 按下撤销按钮
	 */
	public void undoButtonWasPushed() {
		undoCommand.undo();
	}
}
