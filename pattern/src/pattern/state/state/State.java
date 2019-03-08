/**      
 * 模块编号  
 * 功能描述 
 * 文件名 state.java  
 * 作者 王磊 
 * 编写日期 2018年9月6日    
 */
package pattern.state.state;

/**
 * 状态接口
 * 
 * @version 
 * @author 王磊
 */
public interface State {
	
	void handle(String param);
}
