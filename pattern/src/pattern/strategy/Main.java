package pattern.strategy;

import pattern.strategy.impl.Strategy1;
import pattern.strategy.impl.Strategy2;
import pattern.strategy.impl.Strategy3;

/**
* @ClassName: Main 
* @Description: 执行类  相当于赵云
* @author 王磊
*
 */
public class Main {
	public static void main(String[] args) {
		Context context = null;
		System.out.println("刚到吴国,拆开第一个锦囊....");
		context = new Context(new Strategy1());
		context.opreate();
		System.out.println("\n\n\n");
		
		System.out.println("刘备乐不思蜀,拆开第二个锦囊....");
		context = new Context(new Strategy2());
		context.opreate();
		System.out.println("\n\n\n");
		
		System.out.println("孙权追兵追击，拆开第三个.....");
		context = new Context(new Strategy3());
		context.opreate();
	}
}
