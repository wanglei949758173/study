/*      
 * 模块编号  
 * 功能描述 
 * 文件名 SharePie.java 
 * 作者 王磊 
 * 编写日期 2021年04月15日 
 */
package com.wl.study.chapter10.loandemo.version4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.wl.study.chapter10.loandemo.common.Company;
import com.wl.study.chapter10.loandemo.common.Money;
import com.wl.study.chapter10.loandemo.version1.Share;

public class SharePie {
	private Map<Company, Double> rates = new HashMap<>();
	
	private Map<Company, Share> shares;
	
	public Map<Company, Share> getShares() {
		return shares;
	}
	public SharePie(Map<Company, Share> shares) {
		double amount = getAmount(shares);
		Set<Company> owners = shares.keySet();
		for (Company owner : owners) {
			double loanAmount =
					shares.get(owner).getAmount().getValue();
			double loanRate = loanAmount / amount;
			rates.put(owner, loanRate);
		}
		
		this.shares = shares;
	}
	/**
	 * 按比例分配支付的钱
	 * @param paymentMoney	支付的钱
	 * @return				每个出借者获得的钱
	 */
	public SharePie prorate(Money paymentMoney) {
		Map<Company, Share> paymentShares = new HashMap<>();
		Set<Company> lenders = rates.keySet();
		for (Company lender : lenders) {
			Double lendRate = rates.get(lender);
			Double paymentAmount = lendRate * paymentMoney.getValue();
			Share paymentShare = 
					new Share(lender, new Money(paymentAmount));
			paymentShares.put(lender, paymentShare);
		}
		return new SharePie(paymentShares);
	}
	
	/**
	 * 增加贷款股份
	 * @param loanShares 贷款股份
	 */
	public SharePie plus(Map<Company, Share> loanShares) {
		return null;
	}
	
	/**
	 * 减少贷款股份
	 * @param paymentShares	支付的股份
	 */
	public SharePie minus(Map<Company, Share> paymentShares) {
		return null;
	}
	
	public double getAmount(Map<Company, Share> loanShares) {
		double total = 0.0;
		Set<Company> owners = loanShares.keySet();
		for (Company owner : owners) {
			Share loanShare = loanShares.get(owner);
			total += loanShare.getAmount().getValue();
		}
		return total;
	}
}
