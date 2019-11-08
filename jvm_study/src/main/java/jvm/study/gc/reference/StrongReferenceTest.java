/*      
 * 模块编号  
 * 功能描述 
 * 文件名 StrongReferenceTest.java  
 * 作者 王磊 
 * 编写日期 2019年11月8日    
 */
package jvm.study.gc.reference;

/**
 * 强引用测试
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class StrongReferenceTest {
	// 1M大小
	private static final int M = 1024 * 1024;

	private static void printMemory(String label) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println();
		System.out.println(label + "：");
		System.out.println(runtime.freeMemory() / M + "M(free)"
				+ runtime.totalMemory() / M
				+ "M(total)");
	}

	public static void main(String[] args) {
		printMemory("1.原可用内存和总内存");
	}
}
