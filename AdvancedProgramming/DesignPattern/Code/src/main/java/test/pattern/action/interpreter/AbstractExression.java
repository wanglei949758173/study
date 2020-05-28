/*      
 * 模块编号  
 * 功能描述 
 * 文件名 AbstractExression.java 
 * 作者 王磊 
 * 编写日期 2020年05月27日 
 */
package test.pattern.action.interpreter;

import java.util.Map;

public abstract class AbstractExression {
	public abstract int interpreter(Map<String, Integer> var);
}
