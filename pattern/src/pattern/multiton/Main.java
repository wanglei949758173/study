package pattern.multiton;
/**
 * 
* @ClassName: Main 
* @Description: 启动类，相当于大臣
* @author 王磊
*
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("我是来自国家1的大臣，我来参拜我的皇帝......");
		Emperor e1 = Emperor.getInstance("国家1");
		if (e1 != null) {
			System.out.println(e1.getName() + "万岁万岁万万岁....");
		} else {
			System.out.println("哪里来的野民，杀了....");
		}
		
		System.out.println("\n\n\n");
		
		System.out.println("我是来自国家2的大臣，我来参拜我的皇帝......");
		Emperor e2 = Emperor.getInstance("国家2");
		if (e1 != null) {
			System.out.println(e2.getName() + "万岁万岁万万岁....");
		} else {
			System.out.println("哪里来的野民，杀了....");
		}
		
		System.out.println("\n\n\n");
		
		System.out.println("我是来自国家3的大臣，我来参拜我的皇帝......");
		Emperor e3 = Emperor.getInstance("国家3");
		if (e3 != null) {
			System.out.println(e3.getName() + "万岁万岁万万岁....");
		} else {
			System.out.println("哪里来的野民，杀了....");
		}
		
		System.out.println("\n\n\n");
	}
}
