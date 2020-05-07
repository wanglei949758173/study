/*      
 * 模块编号  
 * 功能描述 
 * 文件名 NoCommand.java 
 * 作者 王磊 
 * 编写日期 2020年05月07日 
 */
package test.pattern.structure.command.impl;

import test.pattern.structure.command.Command;

public class NoCommand implements Command {

	@Override
	public void execute() {
		// Nothing to do
	}

	@Override
	public void undo() {
		// Nothing to do
	}

}
