package com.wl.java8.stream;

import java.util.ArrayList;
import java.util.List;

public class T4_UseSortedAndSkipLimit {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.stream().sorted((student1, student2) -> 
					Integer.compare(student1.getAge(), student1.getAge()));
		
		students.stream().skip(0).limit(10);
		
		students.stream().forEach(student -> {
			System.out.println(student.getName());
		});
	}
}
