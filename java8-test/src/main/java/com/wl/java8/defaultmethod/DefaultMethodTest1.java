package com.wl.java8.defaultmethod;

/**
 * 默认方法测试类1
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class DefaultMethodTest1 implements Running, Swimming{
	public static void main(String[] args) {
		DefaultMethodTest1 test = new DefaultMethodTest1();
		test.walk();
		// 输出
		// swim walk......
		// DefaultMethodTest1 walk
	}

	/**
	 * 重名的walk方法必须重写
	 */
	@Override
	public void walk() {
		// 通过Class.super.method()调用父接口的默认方法
		Swimming.super.walk();
		System.out.println("DefaultMethodTest1 walk");
	}
}

interface Running {
	default void run() {
		System.out.println("run....");
	};

	default void walk() {
		System.out.println("run walk.....");
	};
}

interface Swimming {
	default void swim() {
		System.out.println("swim....");
	};

	default void walk() {
		System.out.println("swim walk......");
	};
}
