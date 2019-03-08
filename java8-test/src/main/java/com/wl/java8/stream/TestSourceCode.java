package com.wl.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 流源代码测试
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class TestSourceCode {
	public static void main(String[] args) {
		List<String> list =
				Arrays.asList("zhangsan", "lisi", "wangwu", "hello", "world");

		list.stream().map(String::length).filter(l -> l == 5).forEach(
				System.out::println);
	}
}
