/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ShaMaTeRobot.java  
 * 作者 王磊 
 * 编写日期 2019年12月19日    
 */
package com.jdsn;

/**
 * 杀马特Robot
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class ShaMaTeRobot implements IRobot{

	@Override
	public String playerName() {
		return "wanglei";
	}

	@Override
	public void play(boolean isBlack) {
		// Nothing to do
	}

	@Override
	public Position nextStep() {
		Position position = new Position();
		return position;
	}

	@Override
	public void putChess(Position pos) {	
	}

}
