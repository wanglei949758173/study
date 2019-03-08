package com.wl.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 测试flatMap
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class TestFlatMap {
	public static void main(String[] args) {
		List<String> oneGradeClassList = Arrays.asList("高一一班", "高一二班", "高一三班");
		List<String> twoGradeClassList = Arrays.asList("高二一班", "高二二班", "高二三班");
		List<String> threeGradeClassList =
				Arrays.asList("高三一班", "高三二班", "高三三班", "高三四班");
		List<List<String>> allClassList =
				Arrays.asList(oneGradeClassList,
						twoGradeClassList,
						threeGradeClassList);

		// 要求输出 高一一班，高一二班......高三四班
		allClassList.stream()
				.flatMap(gradeClassList -> gradeClassList.stream())
				.forEach(System.out::println);
	}
}
