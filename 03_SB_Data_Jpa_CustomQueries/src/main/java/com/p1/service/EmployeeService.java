package com.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.p1.entity.Employee;
import com.p1.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	private static final int pageSeize = 3;
	
	@Autowired
	private EmployeeRepo repo;
	
	
	
	// Pagination
	
	public void getEmp(int pageNum) {
		PageRequest page = PageRequest.of(pageNum-1, pageSeize);
		
		 Page<Employee> emps = repo.findAll(page);
		 emps.get().forEach(System.out::print);
	}
	
	//Sorting
	
	public Page<Employee> getEmpSort(int pageNum, String sortBy) {
		 Pageable pageable = PageRequest.of(pageNum-1, pageSeize, Sort.by(sortBy));
		
		 return repo.findAll(pageable);
	}
	
	

}
