/**      
 * 模块编号  
 * 功能描述 
 * 文件名 BuliderA.java  
 * 作者 王磊 
 * 编写日期 2018年8月28日    
 */
package pattern.builder.builder.impl;

import pattern.builder.builder.Builder;
import pattern.builder.product.Sheep;
/**
 * A生成器
 * 
 * @version 
 * @author 王磊
 */
public class BuliderTeLa implements Builder{

	private Sheep sheep = new Sheep();

	@Override
	public void fangLaJiao() {
		sheep.setLajiao("特辣");
	}

	@Override
	public void kao() {
		sheep.setChengshudu("熟透了");
	}

	public Sheep getSheep() {
		return sheep;
	}

}
