package com.wl.java8.function.reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用测试类
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
@SuppressWarnings("all")
public class FunctionReference1 {
	public static void main(String[] args) {
		// 1.构造方法引用
		Student student = Student.newInstance(Student::new);
		Student student2 = Student.newInstance(() -> new Student());// lambda表达式写法

		// 2.静态方法引用
		Function<String, String> function = Student::study;
		Function<String, String> function2 = skill -> Student.study(skill); // lambda表达式写法

		// 3.实例-实例方法引用
		Student student3 = new Student();
		Consumer<Student> consumer = student3::printScore;
		Consumer<Student> consumer2 = score -> student3.printScore(score); // lambda表达式写法

		// 4.类-实例方法引用
		BiConsumer<Student, String> biConsumer = Student::printNameAndGender;
		BiConsumer<Student, String> biConsumer2 =
				(student4, gender) -> student4.printNameAndGender(gender); // lambda表达式写法

	}
}

class Student {
	private String name;
	private int score;

	/**
	 * 创建一个学生实例
	 * @param supplier 生产者接口
	 * @return 学生实例
	 */
	public static Student newInstance(Supplier<Student> supplier) {
		return supplier.get();
	}

	/**
	 * 学习技能方法
	 * @param skill 技能
	 * @return 学习xx技能
	 */
	public static String study(String skill) {
		return "学习技能:" + skill;
	}

	/**
	 * 打印成绩
	 * @param student 学生
	 */
	public void printScore(Student student) {
		System.out.println(student.getScore());
	}

	/**
	 * 打印名字和性别
	 * @param gender 性别
	 */
	public void printNameAndGender(String gender) {
		System.out.println(this.name + gender);
	}

	public String getName() {
		return name;
	}

	public Student() {
		super();
	}

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
