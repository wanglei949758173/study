/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Person.java 
 * 作者 王磊 
 * 编写日期 2020年06月14日 
 */
package study.ioc.bean;

import lombok.Data;

@Data
public class Person {
	// 姓名
	private String name;

	// 年龄
	private Integer age;

	// 昵称
	private String nickName;
}
