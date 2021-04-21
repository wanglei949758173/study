/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Share.java 
 * 作者 王磊 
 * 编写日期 2021年04月15日 
 */
package com.wl.study.chapter10.loandemo.version1;

import com.wl.study.chapter10.loandemo.common.Company;
import com.wl.study.chapter10.loandemo.common.Money;

/**
 * 股份实体
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Share {
	/**
	 * 股份所有者
	 */
	private Company owner;
	
	/**
	 * 股份的数量
	 */
	private Money amount;
	

	public Share(Company owner, Money amount) {
		super();
		this.owner = owner;
		this.amount = amount;
	}

	public Company getOwner() {
		return owner;
	}

	public Money getAmount() {
		return amount;
	}
}
