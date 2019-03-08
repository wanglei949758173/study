/**      
 * 模块编号  
 * 功能描述 
 * 文件名 BuliderWeila.java  
 * 作者 王磊 
 * 编写日期 2018年8月28日    
 */
package pattern.builder.builder.impl;

import pattern.builder.builder.Builder;
import pattern.builder.product.Sheep;

public class BuliderWeiLa implements Builder{
	private Sheep sheep = new Sheep();
	
	@Override
	public void fangLaJiao() {
		sheep.setLajiao("微辣");
	}

	@Override
	public void kao() {
		sheep.setChengshudu("熟透了");
	}

}
