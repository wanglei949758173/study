package com.wl.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试flatMap
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class T3_UseFlatMap {
	public static void main(String[] args) {
		List<Class> classList = new ArrayList<>();
		Class class1 = new Class("1班",
				Arrays.asList(new Student("1_张三", 13), new Student("1_李四", 12)));
		Class class2 = new Class("2班",
				Arrays.asList(new Student("2_张三", 14), new Student("2_李四", 13)));
		Class class3 = new Class("3班",
				Arrays.asList(new Student("3_张三", 15), new Student("3_李四", 14)));
		classList.add(class1);
		classList.add(class2);
		classList.add(class3);

		// 获取所有班级的学生的集合
		classList.stream().flatMap(curClass -> curClass.getStudents().stream())
				.collect(Collectors.toList());

		classList.stream().flatMap(curClass -> curClass.getStudents().stream())
				.sorted((student1, student2) -> Integer.compare(student1.getAge(),
						student2.getAge()))
				.findFirst();
	}
}
