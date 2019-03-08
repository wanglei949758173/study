package com.wl.java8.defaultmethod;

/**
 * 默认方法测试类2
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class DefaultMethodTest2 extends MyImpl implements Running2 {
	public static void main(String[] args) {
		DefaultMethodTest2 test = new DefaultMethodTest2();
		test.walk();
		// 输出 
		// swim walk......   
		// my impl..

	}
}

interface Running2 {
	default void run() {
		System.out.println("run....");
	};

	default void walk() {
		System.out.println("run walk.....");
	};
}

interface Swimming2 {
	default void swim() {
		System.out.println("swim....");
	};

	default void walk() {
		System.out.println("swim walk......");
	};
}

class MyImpl implements Swimming2 {
	@Override
	public void walk() {
		Swimming2.super.walk();
		System.out.println("my impl..");
	}
}
