package com.wl.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class T1_ {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		// 筛选出年龄大于15岁的学生的性能
		List<String> result = new ArrayList<>();
		for (Student student : students) {
			if (student.getAge() > 15) {
				result.add(student.getName());
			}
		}

		result = students.stream().filter(student -> student.getAge() > 15)
				.map(student -> student.getName()).collect(Collectors.toList());
	}
}
