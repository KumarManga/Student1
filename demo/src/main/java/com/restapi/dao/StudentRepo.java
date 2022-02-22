package com.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restapi.entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	
	@Query(value = "select * FROM Student where marks>75", nativeQuery = true)
	List<Student> getAllStudentsPercentageGreaterThan75();
	

}
