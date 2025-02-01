package com.p1.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.p1.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	//	 1. HQL (JPQL) Query - Find employees by department
	@Query("Select e from Employee e where e.department = :department")
	List<Employee> findByDepartment(@Param("department") String department);

//	2.Native SQL Query - Find employees by department
	@Query(value ="Select * from emplayees where name = :name",nativeQuery=true )
	List<Employee> findByName (@Param("name") String name);
	
//   HQL - Find top 3 highest-paid employees
	@Query("Select e from Employee e Order By e.salary Desc")
	List<Employee> findTop3BySalary(Pageable pageable);
	
//  Native SQL - Find top 3 highest-paid employees
	@Query(value ="Select * from emplayees Order By Salary Desc Limit 3;", nativeQuery = true)
	List<Employee> findTop3BySalary();

//   HQL - Update employee salary (requires @Modifying & @Transactional)
	@Modifying
    @Transactional
	@Query("update Employee e Set e.salary = :salary where e.id = :id")
    int updateEmployeeSalary(@Param("id") int id, @Param("salary") double salary);
	
//   Native SQL - Delete employees in a department
	@Modifying
    @Transactional
    @Query(value = "DELETE FROM employees WHERE department = :department", nativeQuery = true)
	int DeleteByDepeartmentNative(@Param("department") String department );
	
	
}
