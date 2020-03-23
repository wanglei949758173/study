/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HouseBuilder.java 
 * 作者 王磊 
 * 编写日期 2020年03月23日 
 */
package test.pattern.creator.builder;

public abstract class HouseBuilder {

	protected House house = new House();
	
	/**
	 * 打地基
	 */
	public abstract void buildBasic();
	
	/**
	 * 砌墙
	 */
	public abstract void buildWalls();
	
	/**
	 * 封顶
	 */
	public abstract void roofed();
	
	/**
	 * 构建房子
	 * @return	房子
	 */
	public House buildHouse() {
		return house;
	}
	
}