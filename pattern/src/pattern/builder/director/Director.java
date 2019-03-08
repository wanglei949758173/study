/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Director.java  
 * 作者 王磊 
 * 编写日期 2018年8月28日    
 */
package pattern.builder.director;

import pattern.builder.builder.Builder;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public void execute() {
		builder.fangLaJiao();
		builder.kao();
	}
}
