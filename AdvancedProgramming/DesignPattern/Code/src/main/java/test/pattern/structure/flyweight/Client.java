/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年04月22日 
 */
package test.pattern.structure.flyweight;

import test.pattern.structure.flyweight.impl.WebSiteFactory;

public class Client {
	public static void main(String[] args) {
		WebSiteFactory webSiteFactory = new WebSiteFactory();
		WebSite crm = webSiteFactory.getWebSite("crm");
		WebSite erp = webSiteFactory.getWebSite("erp");

		System.out.println("使用博客形式看");
		crm.setUI("blog");
		crm.use();
		erp.setUI("blog");
		erp.use();
		System.out.println();

		System.out.println("使用微信公众号形式看");
		crm.setUI("wechat");
		crm.use();
		erp.setUI("wechat");
		erp.use();
		System.out.println();
		
		System.out.println("网站个数：" + webSiteFactory.webSiteCount());

	}
}
