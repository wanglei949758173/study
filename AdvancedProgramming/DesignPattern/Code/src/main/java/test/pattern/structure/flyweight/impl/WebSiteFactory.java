/*      
 * 模块编号  
 * 功能描述 
 * 文件名 WebSiteFactory.java 
 * 作者 王磊 
 * 编写日期 2020年04月22日 
 */
package test.pattern.structure.flyweight.impl;

import java.util.HashMap;
import java.util.Map;

import test.pattern.structure.flyweight.WebSite;

public class WebSiteFactory {
	private Map<String, WebSite> webSites = new HashMap<>();

	public WebSite getWebSite(String type) {
		WebSite webSite = webSites.get(type);
		if (webSite == null) {
			webSite = new ConcreteWebSite(type);
			webSites.put(type, webSite);
		}

		return webSite;
	}

	public int webSiteCount() {
		return webSites.size();
	}
}
