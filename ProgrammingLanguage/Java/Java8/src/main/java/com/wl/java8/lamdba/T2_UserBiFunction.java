package com.wl.java8.lamdba;

import java.util.function.BiFunction;

public class T2_UserBiFunction {

	public static void main(String[] args) {
		T2_UserBiFunction test = new T2_UserBiFunction();
		test.calculate(1, 2, (num1,num2) -> num1 + num2);
		test.calculate(1, 2, (num1,num2) -> num1 - num2);
		test.calculate(1, 2, (num1,num2) -> num1 * num2);
		test.calculate(1, 2, (num1,num2) -> num1 / num2);
	}
	
	public int calculate(int num1, int num2,
			BiFunction<Integer, Integer, Integer> function) {
		System.out.println(function.apply(num1, num2));
		return function.apply(num1, num2);
	}
}
