/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Loan.java 
 * 作者 王磊 
 * 编写日期 2021年04月15日 
 */
package com.wl.study.chapter10.loandemo.version1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.wl.study.chapter10.loandemo.common.Company;
import com.wl.study.chapter10.loandemo.common.Money;

/**
 * 贷款实体
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Loan {
	/**
	 * 所有公司的股份
	 */
	private Map<Company, Share> shares;

	/**
	 * 分配支付金额
	 * @param paymentAmount	支付的总额
	 * @return				给每个公司分配的总额
	 */
	public Map<Company, Share> distributePrincipalPayment(Money paymentAmount) {
		Map<Company, Share> paymentShares = new HashMap<>();
		// 根据总额和每个公司的股份计算每个公司应得的支付额度
		Map<Company, Share> loanShares = getShares();
		double total = getAmount();
		Set<Company> owners = loanShares.keySet();
		for (Company owner : owners) {
			// 获取每个公司应该获取的支付额度
			double initialLoanAmount =
					loanShares.get(owner).getAmount().getValue();
			double paymentShareAmount =
					(initialLoanAmount / total) * paymentAmount.getValue();
			Share paymentShare = new Share(owner, new Money(paymentShareAmount));
			paymentShares.put(owner, paymentShare);
			
			// 修改剩余的金额
			double newLoanShareAmount = initialLoanAmount - paymentShareAmount;
			Share newLoanShare = new Share(owner, new Money(newLoanShareAmount));
			loanShares.put(owner, newLoanShare);
		}
		return paymentShares;
	}

	private double getAmount() {
		Map<Company, Share> loanShares = getShares();
		double total = 0.0;
		Set<Company> owners = loanShares.keySet();
		for (Company owner : owners) {
			Share loanShare = loanShares.get(owner);
			total += loanShare.getAmount().getValue();
		}
		return total;
	}

	public Map<Company, Share> getShares() {
		return shares;
	}
}
