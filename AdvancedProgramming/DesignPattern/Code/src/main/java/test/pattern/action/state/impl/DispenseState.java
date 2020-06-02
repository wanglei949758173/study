/*      
 * 模块编号  
 * 功能描述 
 * 文件名 DispenseState.java 
 * 作者 王磊 
 * 编写日期 2020年06月02日 
 */
package test.pattern.action.state.impl;

import test.pattern.action.state.RaffleActivity;
import test.pattern.action.state.State;

// 发放奖品状态
public class DispenseState extends State {

	public DispenseState(RaffleActivity raffleActivity) {
		super(raffleActivity);
	}

	@Override
	public void deductMoney() {
		System.out.println("已经扣取过了积分");
	}

	@Override
	public boolean raffle() {
		System.out.println("正在发放奖品,不能抽奖");
		return false;
	}

	@Override
	public void dispensePrize() {
		if (this.raffleActivity.getPrizeAmount() > 0) {
			System.out.println("恭喜中奖了");
			// 改变状态为不能抽奖
			this.raffleActivity.setCurrentState(this.raffleActivity.getNoRafflleState());
		} else {
			System.out.println("很遗憾，奖品发送完了");
			// 改变状态为奖品发送完毕, 后面我们就不可以抽奖
			this.raffleActivity.setCurrentState(this.raffleActivity.getDispensOutState());
			System.out.println("抽奖活动结束");
			System.exit(0);
		}
	}

}
