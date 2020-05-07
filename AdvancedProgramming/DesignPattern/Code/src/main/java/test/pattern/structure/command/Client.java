/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年05月07日 
 */
package test.pattern.structure.command;

import test.pattern.structure.command.impl.LightOffCommand;
import test.pattern.structure.command.impl.LightOnCommand;
import test.pattern.structure.command.impl.LightReciver;
import test.pattern.structure.command.impl.TVOffCommand;
import test.pattern.structure.command.impl.TVOnCommand;
import test.pattern.structure.command.impl.TVReciver;

public class Client {
	public static void main(String[] args) {
		// 初始化遥控器
		RemoteController remoteController = new RemoteController();
		LightReciver lightReciver = new LightReciver();
		remoteController.setCommand(0, new LightOnCommand(lightReciver),
				new LightOffCommand(lightReciver));
		TVReciver tvReciver = new TVReciver();
		remoteController.setCommand(1, new TVOnCommand(tvReciver), new TVOffCommand(tvReciver));

		// 打开灯
		System.out.println("---打开电灯---");
		remoteController.onButtonWasPushed(0);
		System.out.println();
		// 关闭灯
		System.out.println("---关闭电灯---");
		remoteController.offButtonWasPushed(0);
		System.out.println();
		
		// 打开电视
		System.out.println("---打开电视---");
		remoteController.onButtonWasPushed(1);
		System.out.println();
		// 关闭灯
		System.out.println("---关闭电视---");
		remoteController.offButtonWasPushed(1);
		System.out.println();
		
		// 撤销
		System.out.println("---撤销---");
		remoteController.undoButtonWasPushed();
	}
}
