/*      
 * 模块编号  
 * 功能描述 
 * 文件名 NoRaffleState.java 
 * 作者 王磊 
 * 编写日期 2020年06月02日 
 */
package test.pattern.action.state.impl;

import test.pattern.action.state.RaffleActivity;
import test.pattern.action.state.State;

// 不能抽奖状态
public class NoRaffleState extends State {

	public NoRaffleState(RaffleActivity raffleActivity) {
		super(raffleActivity);
	}

	@Override
	public void deductMoney() {
		System.out.println("积分-50");
		this.raffleActivity.setCurrentState(this.raffleActivity.getCanRaffleState());
	}

	@Override
	public boolean raffle() {
		System.out.println("未扣除积分,不能抽奖");
		return false;
	}

	@Override
	public void dispensePrize() {
		System.out.println("未中奖,不能发放奖品");
	}

}
