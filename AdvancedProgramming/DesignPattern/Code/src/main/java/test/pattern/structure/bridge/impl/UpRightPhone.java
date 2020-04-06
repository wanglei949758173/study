package test.pattern.structure.bridge.impl;

import test.pattern.structure.bridge.Phone;
import test.pattern.structure.bridge.PhoneFunction;

public class UpRightPhone extends Phone {

	// 构造器
	public UpRightPhone(PhoneFunction phoneFunction) {
		super(phoneFunction);
	}

	public void open() {
		super.open();
		System.out.println(" 直立样式手机 ");
	}

	public void close() {
		super.close();
		System.out.println(" 直立样式手机 ");
	}

	public void call() {
		super.call();
		System.out.println(" 直立样式手机 ");
	}
}