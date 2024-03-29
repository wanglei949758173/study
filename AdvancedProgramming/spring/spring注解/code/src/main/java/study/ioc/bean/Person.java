/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Person.java 
 * 作者 王磊 
 * 编写日期 2020年06月14日 
 */
package study.ioc.bean;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class Person {
	// 姓名
	@Value("zhangsan") // 直接取值
	private String name;

	// 年龄
	@Value("#{20 - 2}") // 表达式
	private Integer age;

	// 昵称
	@Value("${person.nickName}") // 从spring的environment中取值
	private String nickName;

}
