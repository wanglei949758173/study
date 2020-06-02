/*      
 * 模块编号  
 * 功能描述 
 * 文件名 DispenseOutState.java 
 * 作者 王磊 
 * 编写日期 2020年06月02日 
 */
package test.pattern.action.state.impl;

import test.pattern.action.state.RaffleActivity;
import test.pattern.action.state.State;

// 奖品发放完毕状态
public class DispenseOutState extends State {

	public DispenseOutState(RaffleActivity raffleActivity) {
		super(raffleActivity);
	}

	@Override
	public void deductMoney() {
		System.out.println("奖品发送完了，请下次再参加");
	}

	@Override
	public boolean raffle() {
		System.out.println("奖品发送完了，请下次再参加");
		return false;
	}

	@Override
	public void dispensePrize() {
		System.out.println("奖品发送完了，请下次再参加");
	}

}
