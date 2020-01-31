package com.wl.java8.stream;

import java.util.List;

public class Class {
	public Class(String name, List<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}

	private String name;
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
