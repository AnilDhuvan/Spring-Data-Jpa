package com.p1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;

import com.p1.entity.Employee;
import com.p1.repo.EmployeeRepo;
import com.p1.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmployeeRepo bean = context.getBean(EmployeeRepo.class);
		
		List<Employee> byDepartment = bean.findByDepartment("Java developer");
		System.out.println(byDepartment);
		
		List<Employee> byName = bean.findByName("anil");
		System.out.println(byName);
		
		PageRequest of = PageRequest.of(0, 3);
		List<Employee> top3BySalary = bean.findTop3BySalary(of);
		System.out.println(top3BySalary);
		
		List<Employee> top3S = bean.findTop3BySalary();
		System.out.println(top3S);
		
		int updateEmpSalary = bean.updateEmployeeSalary(1, 80000);
		System.out.println(updateEmpSalary);
		
		int deleteDep = bean.DeleteByDepeartmentNative(".Net developer");
		System.out.println(deleteDep);
		
		
	}

}
