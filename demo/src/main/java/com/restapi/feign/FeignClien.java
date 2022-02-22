package com.restapi.feign;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "feign",url = "http://localhost:8080")
public interface FeignClien {
	
	@GetMapping(path = "/feign", produces = "application/json")
	public List<Employee> getAllEmployees(); 
	
	@GetMapping(path = "/feign/{id}", produces = "application/json")
	public Optional<Employee> getEmployeeById(@PathVariable int id);

}
