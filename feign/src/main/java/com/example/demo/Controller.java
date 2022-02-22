package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
public class Controller {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping("/feign")
	public List<Employee> getAllEmployees() {
		return  employeeRepo.findAll();
	}
	
	@GetMapping("/feign/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		return employeeRepo.findById(id);
	}
	
	@PostMapping("/feign")
	public String createEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return "created";
	}

}
