/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Sheep.java  
 * 作者 王磊 
 * 编写日期 2018年8月28日    
 */
package pattern.builder.product;

public class Sheep {
	@Override
	public String toString() {
		return "Sheep [lajiao=" + lajiao + ", chengshudu=" + chengshudu + "]";
	}
	private String lajiao;
	private String chengshudu;
	public String getLajiao() {
		return lajiao;
	}
	public void setLajiao(String lajiao) {
		this.lajiao = lajiao;
	}
	public String getChengshudu() {
		return chengshudu;
	}
	public void setChengshudu(String chengshudu) {
		this.chengshudu = chengshudu;
	}
}
