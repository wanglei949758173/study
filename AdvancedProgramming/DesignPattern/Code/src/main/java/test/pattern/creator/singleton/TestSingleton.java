/*      
 * 模块编号  
 * 功能描述 测试单例模式
 * 文件名 TestSingleton.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.singleton;

public class TestSingleton {
	public static void main(String[] args) {
		System.out.println("饿汉式：");
		HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
		HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
		System.out.println(hungrySingleton1 == hungrySingleton2);
		System.out.println(hungrySingleton1.hashCode());
		System.out.println(hungrySingleton2.hashCode());
		System.out.println();
		
		System.out.println("饱汉式：");
		FullSingleton fullSingleton1 = FullSingleton.getInstance();
		FullSingleton fullSingleton2 = FullSingleton.getInstance();
		System.out.println(fullSingleton1 == fullSingleton2);
		System.out.println(fullSingleton1.hashCode());
		System.out.println(fullSingleton2.hashCode());
		System.out.println();
		
		System.out.println("饱汉式同步方式：");
		FullSingletonThreadSafety fullSingletonThreadSafety1 = FullSingletonThreadSafety.getInstance();
		FullSingletonThreadSafety fullSingletonThreadSafety2 = FullSingletonThreadSafety.getInstance();
		System.out.println(fullSingletonThreadSafety1 == fullSingletonThreadSafety2);
		System.out.println(fullSingletonThreadSafety1.hashCode());
		System.out.println(fullSingletonThreadSafety2.hashCode());
		System.out.println();
		
		System.out.println("饱汉式双重检查方式：");
		FullSingletonDoubleCheck fullSingletonDoubleCheck1 = FullSingletonDoubleCheck.getInstance();
		FullSingletonDoubleCheck fullSingletonDoubleCheck2 = FullSingletonDoubleCheck.getInstance();
		System.out.println(fullSingletonDoubleCheck1 == fullSingletonDoubleCheck2);
		System.out.println(fullSingletonDoubleCheck1.hashCode());
		System.out.println(fullSingletonDoubleCheck2.hashCode());
		System.out.println();
		
		System.out.println("静态内部类方式：");
		StaticInnerClassSingleton staticInnerClassSingleton1 = StaticInnerClassSingleton.getInstance();
		StaticInnerClassSingleton staticInnerClassSingleton2 = StaticInnerClassSingleton.getInstance();
		System.out.println(staticInnerClassSingleton1 == staticInnerClassSingleton2);
		System.out.println(staticInnerClassSingleton1.hashCode());
		System.out.println(staticInnerClassSingleton2.hashCode());
		System.out.println();
		
		System.out.println("枚举方式：");
		EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
		EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
		System.out.println(enumSingleton1 == enumSingleton2);
		System.out.println(enumSingleton1.hashCode());
		System.out.println(enumSingleton2.hashCode());
	}
}
