package pattern.multiton;
/**
 * 
* @ClassName: Emperor 
* @Description: 皇帝类
* @author 王磊
*
 */

import java.util.ArrayList;

public class Emperor {
	/**
	 * 皇帝名字
	 */
	private String name;
	/**
	 * 皇帝国家
	 */
	private String country;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private Emperor() {
		
	}
	
	private Emperor(String name, String country) {
		this.name = name;
		this.country = country;
	}

	private static int maxNumOfEmperor = 2;//最多只能有两个皇帝
	
	private static ArrayList<Emperor> emperorList = new ArrayList<Emperor>(maxNumOfEmperor);//皇帝列表
	
	//生产出两个皇帝
	static {
		for (int i = 0; i < maxNumOfEmperor; i++) {
			emperorList.add(new Emperor("皇帝" + (i+1), "国家" + (i+1)));
		}
	}
	
	public static Emperor getInstance(String countryName) {
		for (Emperor emperor : emperorList) {
			if (countryName.equals(emperor.getCountry())) {
				return emperor;
			}
		}
		return null;
	}
	
}
