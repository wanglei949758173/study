/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Test.java  
 * 作者 王磊 
 * 编写日期 2018年8月16日    
 */
package pattern;

public class Test {
	public static void main(String[] args) {

		Student s1 = new Student();
		s1.setName("张三");
		s1.setGrade("1年级");
		s1.setAge(7);
		
		System.out.println(s1.getAge());
		
		editStudent(s1);
		System.out.println(s1.getAge());
	}

	private static void editStudent(Student student) {
		student.setAge(100);
	}

}

class Student {
	private String name;
	private int age;
	private String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
