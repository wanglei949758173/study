/**      
 * 模块编号  
 * 功能描述 
 * 文件名 College.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.mediator.college;

import pattern.mediator.mediator.Mediator;

/**
 * 同事抽象类
 * 
 * @version 
 * @author 王磊
 */
public abstract class College {
	private Mediator mediator;

	public College(Mediator mediator) {
		this.mediator = mediator;
	}

	public Mediator getMediator() {
		return mediator;
	}
}
