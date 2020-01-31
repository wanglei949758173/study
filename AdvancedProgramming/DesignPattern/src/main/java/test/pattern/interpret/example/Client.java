/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2019年5月23日    
 */
package test.pattern.interpret.example;

public class Client {
	public static void main(String[] args) {
		String statement = "3 * 4 * 4 / 6 % 3";
		Calculator calculator = new Calculator();
		calculator.build(statement);

		int result = calculator.compute();
		System.out.println(statement + " = " + result);
		
	}
}
