package com.wl.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T7_Group {
	public static void main(String[] args) {
		// 分组
		List<Student> students = Arrays.asList(new Student("zhangsan", 12),
				new Student("lisi", 12), new Student("wangwu", 13));

		Map<Integer, List<Student>> map = students.stream()
				.collect(Collectors.groupingBy(student -> student.getAge()));
		System.out.println(map);

		Map<Boolean, List<Student>> map2 = students.stream()
				.collect(Collectors.partitioningBy(student -> student.getAge() >= 13));
		System.out.println(map2);
	}
}
