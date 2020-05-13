/*      
 * 模块编号  
 * 功能描述 
 * 文件名 NoVote.java 
 * 作者 王磊 
 * 编写日期 2020年05月09日 
 */
package test.pattern.action.visitor.impl;

import test.pattern.action.visitor.Vote;

public class NoVote implements Vote{
	@Override
	public void vote(Audience audience) {
		System.out.println(String.format("性别：%s,弃权", audience.getGender()));
	}
}
