package com.example.demo.student;

import lombok.Data;

@Data

public class Student {

	private int id;
	private String name;
	private String passportNumber;

	public Student() {

	}

	public Student(int id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
	}

}
