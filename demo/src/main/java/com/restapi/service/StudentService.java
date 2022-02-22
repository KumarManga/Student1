package com.restapi.service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.restapi.dao.StudentRepo;
import com.restapi.entities.Student;
import com.restapi.exceptionhandlingconroller.StudentResourceNotFoundException;
import com.restapi.feign.Employee;
import com.restapi.feign.FeignClien;

import lombok.var;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private FeignClien feignClient;

	public Student saveStudent(Student student) {
		Optional<Employee> e = feignClient.getEmployeeById(1);
		student.setFeign(e.get().getName());
		
		return repo.save(student);
	}

	public List<Student> getAllStudentsByMarks() {
		List<Student> student = repo.findAll();

		if (student.isEmpty()) {
			throw new StudentResourceNotFoundException("Student Records not found");
		} else {
			
			
			Collections.sort(student);
			return student;
		}
	}
	
	public List<Student> getAllStudents() {
		List<Student> student = repo.findAll();

		if (student.isEmpty()) {
			throw new StudentResourceNotFoundException("Student Records not found");
		} else {
			return student;
		}
		
	}

	public Optional<Student> getStudentById(Long id) {
		Optional<Student> student = repo.findById(id);
		if (student.isPresent()) {
			return repo.findById(id);
		} else {
			throw new StudentResourceNotFoundException("Record not found with id : " + id);

		}
	}

	public Student updateStudent(Student student, Long id) {

		Optional<Student> studentDb = this.repo.findById(id);
		if (studentDb.isPresent()) {

			Student studentUpdate = studentDb.get();
			student.setStudentId(studentUpdate.getStudentId());
			studentUpdate.setName(student.getName());
			studentUpdate.setSecondName(student.getSecondName());
			studentUpdate.setMarks(student.getMarks());
			repo.save(student);
			return studentUpdate;
		} else {
			throw new StudentResourceNotFoundException("Record not found with id : " + id);
		}

	}

	public void deleteStudent(Long id) {
		Optional<Student> student = repo.findById(id);
		if (student.isPresent()) {
			repo.deleteById(id);
		} else {
			throw new StudentResourceNotFoundException("Record not found with id : " + id);
		}
	}
	
	public List<Student> getStudentsMarksGreaterThan75(){
		List<Student> students = repo.getAllStudentsPercentageGreaterThan75();
		return students;
	}
	
	public void uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(new File("C:\\Users\\mkuma\\OneDrive\\Desktop\\My_workspace\\demo\\file\\"+file.getOriginalFilename()));
	}
	
	

}
