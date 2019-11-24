package com.wl.java8.lamdba;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class T1_Anonymous_Class {
	public static void main(String[] args) {
		Button button = new Button();
		// 添加动作监听器
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
			}
		});
	}
}
