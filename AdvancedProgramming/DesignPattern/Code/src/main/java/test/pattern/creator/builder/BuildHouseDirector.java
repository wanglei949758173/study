/*      
 * 模块编号  
 * 功能描述 
 * 文件名 BuildHouseDirector.java 
 * 作者 王磊 
 * 编写日期 2020年03月23日 
 */
package test.pattern.creator.builder;

public class BuildHouseDirector {
	private HouseBuilder houseBuilder;

	public BuildHouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	public House constructHouse() {
		houseBuilder.buildBasic();
		houseBuilder.buildWalls();
		houseBuilder.roofed();
		return houseBuilder.buildHouse();
	}
}
