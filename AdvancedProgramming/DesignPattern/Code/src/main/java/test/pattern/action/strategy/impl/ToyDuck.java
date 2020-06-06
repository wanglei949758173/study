/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ToyDuck.java 
 * 作者 王磊 
 * 编写日期 2020年06月06日 
 */
package test.pattern.action.strategy.impl;

import test.pattern.action.strategy.Duck;

public class ToyDuck extends Duck {

	public ToyDuck() {
		flyBehavior = new NoFlyBehavior();
	}

	@Override
	public void display() {
		System.out.println("玩具鸭");
	}

	// 需要重写父类的所有方法
	public void quack() {
		System.out.println("玩具鸭不能叫~~");
	}

	public void swim() {
		System.out.println("玩具鸭不会游泳~~");
	}
}
