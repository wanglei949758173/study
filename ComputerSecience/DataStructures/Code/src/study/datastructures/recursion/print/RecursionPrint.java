/*      
 * 模块编号  
 * 功能描述 
 * 文件名 RecursionPrint.java 
 * 作者 王磊 
 * 编写日期 2020年04月02日 
 */
package study.datastructures.recursion.print;

public class RecursionPrint {
	public static void main(String[] args) {
		print(4);// 结果2,3,4
	}
	
	public static void print(int numer) {
		if (numer > 2) {
			print(numer - 1);
		}
		System.out.println(String.format("number=%d", numer));
	}
}
