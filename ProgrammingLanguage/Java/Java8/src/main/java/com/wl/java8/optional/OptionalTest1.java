package com.wl.java8.optional;

import java.util.Optional;

/**
 * Optional测试类1
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
@SuppressWarnings("all")
public class OptionalTest1 {
	public static void main(String[] args) {

		// 1.创建一个包装了null的容器
		Optional<Integer> optional = Optional.empty();

		// 2.创建了一包装了一定不为null的值的容器
		Optional<Integer> optional1 = Optional.of(1300);

		// 3.创建了一包装了一个不确定是否为null的值的容器
		// 薪水，从数据库中查出来的值，不确定是否为null
		Integer salary = 1500;
		Optional<Integer> optional3 = Optional.ofNullable(salary);

		optional.get(); // 抛异常
		Integer defaultValue = optional.orElse(0);// 如果包装了一个null值则返回0
		optional.orElseGet(() -> 0);// 如果包装了一个null值则返回0
		optional.orElseThrow(() -> new RuntimeException()); // 如果包装了一个null值则抛异常
		/**
		 * 还有类似于流操作的响应方法:filter map flatMap
		 */
	}
}
