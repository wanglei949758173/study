/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HighHouseBuilder.java 
 * 作者 王磊 
 * 编写日期 2020年03月23日 
 */
package test.pattern.creator.builder;

public class HighHouseBuilder extends HouseBuilder {

	@Override
	public void buildBasic() {
		System.out.println(" 高楼的打地基100米 ");
	}

	@Override
	public void buildWalls() {
		System.out.println(" 高楼的砌墙20cm ");
	}

	@Override
	public void roofed() {
		System.out.println(" 高楼的透明屋顶 ");
	}

}
