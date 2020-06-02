/*      
 * 模块编号  
 * 功能描述 
 * 文件名 CanRaffleState.java 
 * 作者 王磊 
 * 编写日期 2020年06月02日 
 */
package test.pattern.action.state.impl;

import java.util.Random;

import test.pattern.action.state.RaffleActivity;
import test.pattern.action.state.State;

// 可以抽奖状态
public class CanRaffleState extends State {

	public CanRaffleState(RaffleActivity raffleActivity) {
		super(raffleActivity);
	}

	@Override
	public void deductMoney() {
		System.out.println("已经扣取过了积分");
	}

	@Override
	public boolean raffle() {
		System.out.println("正在抽奖，请稍等！");
		Random r = new Random();
		int num = r.nextInt(10);
		// 10%中奖机会
		if (num == 0) {
			// 改变活动状态为发放奖品 context
			this.raffleActivity.setCurrentState(this.raffleActivity.getDispenseState());
			return true;
		} else {
			System.out.println("很遗憾没有抽中奖品！");
			// 改变状态为不能抽奖
			this.raffleActivity.setCurrentState(this.raffleActivity.getNoRafflleState());
			return false;
		}
	}

	@Override
	public void dispensePrize() {
		System.out.println("未中奖,不能发放奖品");
	}

}
