package com.wl.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class T2_UseMapAndFilter {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.stream().map(student -> student.getName()).collect(Collectors.toList());
		students.stream().filter(student -> student.getAge() > 10)
				.collect(Collectors.toList());
	}
}
