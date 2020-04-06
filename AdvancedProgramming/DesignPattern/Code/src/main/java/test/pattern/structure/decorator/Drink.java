/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Drink.java 
 * 作者 王磊 
 * 编写日期 2020年04月06日 
 */
package test.pattern.structure.decorator;

public abstract class Drink {
	private String description;
	private float price = 0.0f;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public abstract float cost();

}
