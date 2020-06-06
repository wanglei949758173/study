/*      
 * 模块编号  
 * 功能描述 
 * 文件名 NoFlyBehavior.java 
 * 作者 王磊 
 * 编写日期 2020年06月06日 
 */
package test.pattern.action.strategy.impl;

import test.pattern.action.strategy.FlyBehavior;

public class NoFlyBehavior implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("不会飞翔");
	}

}
