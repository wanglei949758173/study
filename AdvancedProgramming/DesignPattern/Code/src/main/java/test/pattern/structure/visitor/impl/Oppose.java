/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Oppose.java 
 * 作者 王磊 
 * 编写日期 2020年05月09日 
 */
package test.pattern.structure.visitor.impl;

import test.pattern.structure.visitor.Vote;

public class Oppose implements Vote {
	@Override
	public void vote(Audience audience) {
		System.out.println(String.format("性别：%s,投反对票", audience.getGender()));
	}
}
