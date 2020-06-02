/*      
 * 模块编号  
 * 功能描述 
 * 文件名 RaffleActivity.java 
 * 作者 王磊 
 * 编写日期 2020年06月02日 
 */
package test.pattern.action.state;

import test.pattern.action.state.impl.CanRaffleState;
import test.pattern.action.state.impl.DispenseOutState;
import test.pattern.action.state.impl.DispenseState;
import test.pattern.action.state.impl.NoRaffleState;

// 抽奖活动类,相当于context
public class RaffleActivity {
	// 当前状态
	private State currentState;

	// 奖品数量
	private int prizeAmount;

	// 4种状态
	private State noRafflleState = new NoRaffleState(this);
	private State canRaffleState = new CanRaffleState(this);
	private State dispenseState = new DispenseState(this);
	private State dispensOutState = new DispenseOutState(this);

	public RaffleActivity(int prizeAmount) {
		super();
		this.prizeAmount = prizeAmount;
		this.currentState = getNoRafflleState();
	}

	// 扣积分
	public void debuctMoney() {
		currentState.deductMoney();
	}

	// 抽奖
	public void raffle() {
		// 如果当前的状态是抽奖成功
		if (currentState.raffle()) {
			// 领取奖品
			currentState.dispensePrize();
			this.prizeAmount--;
		}
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public int getPrizeAmount() {
		return prizeAmount;
	}

	public void setPrizeAmount(int prizeAmount) {
		this.prizeAmount = prizeAmount;
	}

	public State getNoRafflleState() {
		return noRafflleState;
	}

	public void setNoRafflleState(State noRafflleState) {
		this.noRafflleState = noRafflleState;
	}

	public State getCanRaffleState() {
		return canRaffleState;
	}

	public void setCanRaffleState(State canRaffleState) {
		this.canRaffleState = canRaffleState;
	}

	public State getDispenseState() {
		return dispenseState;
	}

	public void setDispenseState(State dispenseState) {
		this.dispenseState = dispenseState;
	}

	public State getDispensOutState() {
		return dispensOutState;
	}

	public void setDispensOutState(State dispensOutState) {
		this.dispensOutState = dispensOutState;
	}
}
