package com.restapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Comparable<Student> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

//	@Column(name = "name")
	private String name;
	private String secondName;
//	@Column(name = "marks")
	private String marks;
	private String feign;

	@Override
	public int compareTo(Student s) {

		return marks.compareTo(s.marks);
	}

}
