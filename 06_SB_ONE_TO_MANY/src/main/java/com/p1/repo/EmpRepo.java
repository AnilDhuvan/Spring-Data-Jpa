package com.p1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
