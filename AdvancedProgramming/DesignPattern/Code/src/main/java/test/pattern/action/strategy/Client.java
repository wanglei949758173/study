/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年06月06日 
 */
package test.pattern.action.strategy;

import test.pattern.action.strategy.impl.NoFlyBehavior;
import test.pattern.action.strategy.impl.PekingDuck;
import test.pattern.action.strategy.impl.ToyDuck;
import test.pattern.action.strategy.impl.WildDuck;

public class Client {
	public static void main(String[] args) {
		WildDuck wildDuck = new WildDuck();
		wildDuck.display();
		wildDuck.fly();

		System.out.println();
		ToyDuck toyDuck = new ToyDuck();
		toyDuck.display();
		toyDuck.fly();

		System.out.println();
		PekingDuck pekingDuck = new PekingDuck();
		pekingDuck.display();
		pekingDuck.fly();

		// 动态改变某个对象的行为, 北京鸭 不能飞
		pekingDuck.setFlyBehavior(new NoFlyBehavior());
		System.out.println("北京鸭的实际飞翔能力");
		pekingDuck.fly();
	}
}
