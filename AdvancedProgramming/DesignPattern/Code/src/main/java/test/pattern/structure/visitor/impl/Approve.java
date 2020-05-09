/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Approve.java 
 * 作者 王磊 
 * 编写日期 2020年05月09日 
 */
package test.pattern.structure.visitor.impl;

import test.pattern.structure.visitor.Vote;

/**
 * 支持票
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Approve implements Vote {
	@Override
	public void vote(Audience audience) {
		System.out.println(String.format("性别：%s,投赞成票", audience.getGender()));
	}

}
