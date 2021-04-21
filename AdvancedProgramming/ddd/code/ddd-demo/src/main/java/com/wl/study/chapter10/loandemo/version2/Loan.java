/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Loan.java 
 * 作者 王磊 
 * 编写日期 2021年04月15日 
 */
package com.wl.study.chapter10.loandemo.version2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.wl.study.chapter10.loandemo.common.Company;
import com.wl.study.chapter10.loandemo.common.Money;
import com.wl.study.chapter10.loandemo.version1.Share;

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
	 * 计算每个出借人应该获得的股份
	 * @param paymentAmount	支付的总额
	 * @return				每个出借人获得的股份
	 */
	public Map<Company, Share> calculatePrincipalPaymentShares(Money paymentAmount) {
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
		}
		return paymentShares;
	}
	
	/**
	 * 应用支付的股份(副作用函数)
	 * @param paymentShares 支付的股份
	 */
	public void applyPrincipalPaymentShares(Map<Company, Share> paymentShares) {
		Map<Company, Share> loanShares = getShares();
		Set<Company> lenders = loanShares.keySet(); // 出借人列表
		for (Company lender : lenders) {
			// 修改剩余的金额
			double paymentShareAmount = 
					paymentShares.get(lender).getAmount().getValue();
			double initialLoanAmount = 
					loanShares.get(lender).getAmount().getValue();
			double newLoanShareAmount = initialLoanAmount - paymentShareAmount;
			Share newLoanShare = new Share(lender, new Money(newLoanShareAmount));
			loanShares.put(lender, newLoanShare);
		}
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
