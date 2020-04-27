/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年04月26日 
 */
package test.pattern.structure.templatemethod;

import test.pattern.structure.templatemethod.impl.BlackBeanSoyaMilk;
import test.pattern.structure.templatemethod.impl.RedBeanSoyaMilk;

public class Client {
	public static void main(String[] args) {
		SoyaMilk blackBeanSoyaMilk = new BlackBeanSoyaMilk();
		blackBeanSoyaMilk.make();
		
		System.out.println();
		
		SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
		redBeanSoyaMilk.make();
	}
}
