/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年05月27日 
 */
package test.pattern.action.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Client {
	public static void main(String[] args) throws IOException {
		String expressionStr = getExpStr();// a+b-c
		Map<String, Integer> var = getValue(expressionStr);// {a=20,b=10,c=5}
		Caculator caculator = new Caculator();
		int result = caculator.compute(expressionStr, var);
		System.out.println(String.format("%s=%d", expressionStr, result));
	}

	// 获得表达式
	public static String getExpStr() throws IOException {
		System.out.print("请输入表达式：");
		return (new BufferedReader(new InputStreamReader(System.in))).readLine();
	}

	// 获得值映射
	public static Map<String, Integer> getValue(String expressionStr) throws IOException {
		Map<String, Integer> map = new HashMap<>();

		for (char ch : expressionStr.toCharArray()) {
			if (ch != '+' && ch != '-') {
				if (!map.containsKey(String.valueOf(ch))) {
					System.out.print("请输入" + String.valueOf(ch) + "的值：");
					String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					map.put(String.valueOf(ch), Integer.valueOf(in));
				}
			}
		}

		return map;
	}
}
