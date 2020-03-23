/*      
 * 模块编号  
 * 功能描述 
 * 文件名 CloneSheep.java 
 * 作者 王磊 
 * 编写日期 2020年03月23日 
 */
package test.pattern.creator.prototype;

public class CloneSheep implements Cloneable {
	private String name;

	private int age;

	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "CloneSheep [name=" + name + ", age=" + age + ", color=" + color + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
