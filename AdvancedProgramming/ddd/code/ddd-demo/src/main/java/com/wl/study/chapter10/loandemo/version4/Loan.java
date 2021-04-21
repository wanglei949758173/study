/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Loan.java 
 * 作者 王磊 
 * 编写日期 2021年04月15日 
 */
package com.wl.study.chapter10.loandemo.version4;

import java.util.Map;

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
	 * 所有公司的股份比
	 */
	private SharePie shares;

	/**
	 * 计算每个出借人应该获得的股份
	 * @param paymentAmount	支付的总额
	 * @return				每个出借人获得的股份
	 */
	public SharePie calculatePrincipalPaymentShares(Money paymentAmount) {
		return shares.prorate(paymentAmount);
	}
	
	/**
	 * 应用支付的股份(副作用函数)
	 * @param paymentShares 支付的股份
	 */
	public void applyPrincipalPaymentShares(Map<Company, Share> paymentShares) {
		shares.minus(paymentShares);
	}
}
