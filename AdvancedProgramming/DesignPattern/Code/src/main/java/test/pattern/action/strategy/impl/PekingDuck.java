/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PekingDuck.java 
 * 作者 王磊 
 * 编写日期 2020年06月06日 
 */
package test.pattern.action.strategy.impl;

import test.pattern.action.strategy.Duck;

public class PekingDuck extends Duck {
	// 假如北京鸭可以飞翔，但是飞翔技术一般
	public PekingDuck() {
		flyBehavior = new BadFlyBehavior();

	}

	@Override
	public void display() {
		System.out.println("~~北京鸭~~~");
	}
}
