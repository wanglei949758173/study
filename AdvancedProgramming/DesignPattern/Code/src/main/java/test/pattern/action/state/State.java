/*      
 * 模块编号  
 * 功能描述 
 * 文件名 State.java 
 * 作者 王磊 
 * 编写日期 2020年06月02日 
 */
package test.pattern.action.state;

public abstract class State {
	// 抽奖活动
	protected RaffleActivity raffleActivity;
	
	public State(RaffleActivity raffleActivity) {
		super();
		this.raffleActivity = raffleActivity;
	}

	// 扣除积分 - 50
	public abstract void deductMoney();

	// 抽奖
	public abstract boolean raffle();

	// 发放奖品
	public abstract void dispensePrize();
}
