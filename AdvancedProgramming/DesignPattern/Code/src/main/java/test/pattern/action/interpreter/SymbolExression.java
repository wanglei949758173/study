/*      
 * 模块编号  
 * 功能描述 
 * 文件名 SymbolExression.java 
 * 作者 王磊 
 * 编写日期 2020年05月27日 
 */
package test.pattern.action.interpreter;

public abstract class SymbolExression extends AbstractExression {
	protected AbstractExression left;
	protected AbstractExression right;

	public SymbolExression(AbstractExression left, AbstractExression right) {
		super();
		this.left = left;
		this.right = right;
	}
}
