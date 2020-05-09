/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Vote.java 
 * 作者 王磊 
 * 编写日期 2020年05月09日 
 */
package test.pattern.structure.visitor;

import test.pattern.structure.visitor.impl.Audience;

/**
 * 选票接口
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public interface Vote {
	void vote(Audience audience);
}
