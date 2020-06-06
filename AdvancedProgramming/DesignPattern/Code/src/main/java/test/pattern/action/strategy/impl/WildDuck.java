/*      
 * 模块编号  
 * 功能描述 
 * 文件名 WildDuck.java 
 * 作者 王磊 
 * 编写日期 2020年06月06日 
 */
package test.pattern.action.strategy.impl;

import test.pattern.action.strategy.Duck;

public class WildDuck extends Duck {

	// 构造器，传入FlyBehavor 的对象
	public WildDuck() {
		flyBehavior = new GoodFlyBehavior();
	}

	@Override
	public void display() {
		System.out.println(" 这是野鸭 ");
	}

}
