/*      
 * 模块编号  
 * 功能描述 
 * 文件名 RecursionFactorial.java 
 * 作者 王磊 
 * 编写日期 2020年04月02日 
 */
package study.datastructures.recursion.factorial;

public class RecursionFactorial {
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}

	public static int factorial(int numer) {
		if (numer <= 1) {
			return numer;
		} else {
			return numer * factorial(numer - 1);
		}
	}
}
