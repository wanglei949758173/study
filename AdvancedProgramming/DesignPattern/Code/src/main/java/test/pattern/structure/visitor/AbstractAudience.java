/*      
 * 模块编号  
 * 功能描述 
 * 文件名 AbstractAudience.java 
 * 作者 王磊 
 * 编写日期 2020年05月09日 
 */
package test.pattern.structure.visitor;

/**
 * 观众抽象类
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public abstract class AbstractAudience {
	/**
	 * 观众投票
	 * @param vote	选票,访问者
	 */
	public abstract void vote(Vote vote);
}
