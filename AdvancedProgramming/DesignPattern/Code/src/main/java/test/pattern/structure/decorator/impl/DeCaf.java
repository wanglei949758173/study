/*      
 * 模块编号  
 * 功能描述 
 * 文件名 DeCaf.java 
 * 作者 王磊 
 * 编写日期 2020年04月06日 
 */
package test.pattern.structure.decorator.impl;

public class DeCaf extends Coffee {

	public DeCaf() {
		super();
		setDescription(" 无因咖啡 ");
		setPrice(1.0f);
	}

}
