package com.wl.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class T5_UseReduce {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("zhangsan", 12),
				new Student("lisi", 14), new Student("wangwu", 13));

		// 求所有学生年龄的总和
		OptionalInt result = students.stream().mapToInt(student -> student.getAge())
				.reduce((left, right) -> left + right);

		int total = result.orElseGet(() -> 0);
		System.out.println(total);
	}
}
