/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Phone.java 
 * 作者 王磊 
 * 编写日期 2020年03月31日 
 */
package test.pattern.structure.bridge;

public abstract class Phone {
	private PhoneFunction phoneFunction;

	public Phone(PhoneFunction phoneFunction) {
		super();
		this.phoneFunction = phoneFunction;
	}

	protected void open() {
		phoneFunction.open();
	}

	protected void close() {
		phoneFunction.close();
	}

	protected void call() {
		phoneFunction.call();
	}
}
