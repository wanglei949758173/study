/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.composite;

import pattern.composite.component.Component;
import pattern.composite.component.impl.Composite;
import pattern.composite.component.impl.Leaf;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		Component yifu = new Composite("衣服");
		
		Component nanzhuang = new Composite("男装");
		nanzhuang.addChild(new Leaf("短裤"));
		Component nvzhuang = new Composite("女装");
		nvzhuang.addChild(new Leaf("短裙"));
		yifu.addChild(nanzhuang);
		yifu.addChild(nvzhuang);
		
		yifu.someOperation();
	}
}
