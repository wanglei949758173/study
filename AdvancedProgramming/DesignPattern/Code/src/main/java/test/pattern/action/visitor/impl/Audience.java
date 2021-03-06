/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Audience.java 
 * 作者 王磊 
 * 编写日期 2020年05月09日 
 */
package test.pattern.action.visitor.impl;

import test.pattern.action.visitor.AbstractAudience;
import test.pattern.action.visitor.Vote;

public class Audience extends AbstractAudience {
	private String gender;

	public Audience(String gender) {
		super();
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	@Override
	public void vote(Vote vote) {
		vote.vote(this);
		;
	}

}
