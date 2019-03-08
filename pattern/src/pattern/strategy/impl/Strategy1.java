package pattern.strategy.impl;

import pattern.strategy.IStrategy;
/**
 * 
* @ClassName: Strategy1
* @Description: 策略1
* @author 王磊
*
 */
public class Strategy1 implements IStrategy{

	@Override
	public void operate() {
		System.out.println("执行策略1.......");
	}

}
