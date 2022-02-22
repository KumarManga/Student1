package com.restapi.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restapi.entities.Student;
import com.restapi.exceptionhandlingconroller.StudentResourceNotFoundException;
import com.restapi.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(protocols = "http")
public class StudentController {

	@Autowired
	private StudentService service;

	Logger log = LoggerFactory.getLogger(StudentController.class);

	@PostMapping("/student")
	@ApiOperation(value = "saving data", response = Student.class, code = 201, /* hidden = true, */notes = "Don't include any info")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveStudent(@RequestBody Student student) {
		log.info("Post mapping");
		service.saveStudent(student);
		return "Student profile is created";

	}

	@GetMapping("/students")
	public List<Student> getAllStudentsByMarks() {
		return service.getAllStudentsByMarks();

	}
	
	@GetMapping("/student")
	public List<Student> getAllStudents() {
		return service.getAllStudents();

	}

	@GetMapping("/student/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id)throws StudentResourceNotFoundException {
		return service.getStudentById(id);
	}

	@PutMapping("/student/{id}")
	public Student updateSudent(@RequestBody Student student, @PathVariable Long id) {
//		log.debug("debugging the app");
		return service.updateStudent(student, id);
	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "Student is deleted ";

	}
	
	@GetMapping("/getStudentsMarksGreaterThan75")
	public List<Student> getStudentsMarksGreaterThan75(){
		log.info("get all students");
		return service.getStudentsMarksGreaterThan75();
	}
	
	
//	private FileStorageService fileStorageService;
//	
//	@Autowired
//	 public StudentController(FileStorageService fileStorageService) {
//		super();
//		this.fileStorageService = fileStorageService;
//	}
//
//	@PostMapping("/uploadFile")
//	    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//	        String fileName = fileStorageService.storeFile(file);
//
//	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//	                .path("/downloadFile/")
//	                .path(fileName)
//	                .toUriString();
//
//	        return new UploadFileResponse(fileName, fileDownloadUri,
//	                file.getContentType(), file.getSize());
//	    }
	@PostMapping("/file")
	public String fileUpload(@RequestBody MultipartFile file) throws IllegalStateException, IOException {
		service.uploadFile(file);
		return "File uploaded";
		
	}
	

}
