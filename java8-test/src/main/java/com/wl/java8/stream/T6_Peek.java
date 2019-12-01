package com.wl.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 测试peek
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class T6_Peek {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		List<String> stringList =
				Arrays.asList("h",
						"e",
						"l",
						"l",
						"o",
						" ",
						"w",
						"o",
						"r",
						"l",
						"d");
		// 要求把stringList的所有字符join到sb中,同时打印出所有字符
		stringList.stream().peek(sb::append).forEach(System.out::println);
		System.out.println(sb.toString());
	}
}
