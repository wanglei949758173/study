package pattern.strategy.impl;

import pattern.strategy.IStrategy;
/**
 * 
* @ClassName: Strategy3
* @Description: 策略3
* @author 王磊
*
 */
public class Strategy2 implements IStrategy{

	@Override
	public void operate() {
		System.out.println("执行策略2.......");
	}

}
