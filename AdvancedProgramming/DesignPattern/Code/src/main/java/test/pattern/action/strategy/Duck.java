/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Duck.java 
 * 作者 王磊 
 * 编写日期 2020年06月06日 
 */
package test.pattern.action.strategy;

public abstract class Duck {
	// 属性, 策略接口
	protected FlyBehavior flyBehavior;
	// 其它属性<->策略接口
	protected QuackBehavior quackBehavior;

	public Duck() {

	}

	// 显示鸭子信息
	public abstract void display();

	public void quack() {
		System.out.println("鸭子嘎嘎叫~~");
	}

	public void swim() {
		System.out.println("鸭子会游泳~~");
	}

	public void fly() {
		// 改进
		if (flyBehavior != null) {
			flyBehavior.fly();
		}
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
}
