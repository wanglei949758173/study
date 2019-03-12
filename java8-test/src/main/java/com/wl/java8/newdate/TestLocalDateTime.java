/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestLocalDateTime.java  
 * 作者 王磊 
 * 编写日期 2019年3月12日    
 */
package com.wl.java8.newdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class TestLocalDateTime {
	public static void main(String[] args) {
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("currentTime:	" + currentTime);

		LocalDate localDate = currentTime.toLocalDate();
		System.out.println("localDate:	" + localDate);

		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();
		System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);
		
		
	}
}
