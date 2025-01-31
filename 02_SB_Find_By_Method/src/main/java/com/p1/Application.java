package com.p1;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.p1.entity.Student;
import com.p1.repo.StudentRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		 StudentRepo bean = context.getBean(StudentRepo.class);
		
//		Student s1 = new Student("anil",18,"anil@gmail.com", "Anil@88900");
//		Student s2 = new Student("dev",28,"dev@gmail.com", "dev@88900");
//		Student s3 = new Student("aman",12,"aman@gmail.com", "amil@88900");
//		Student s4 = new Student("lokesh",19,"lokesh@gmail.com", "mil@88900");
//		Student s5 = new Student("bharat",18,"bharat@gmail.com", "thAnil@88900");
//		Student s6 = new Student("sumit",24,"sumit@gmail.com", "908Anil@88900");
//		Student s7 = new Student("Rahul",19,"Rahul@gmail.com", "astAnil@88900");
//		Student s8 = new Student("sonu",21,"sonu@gmail.com", "Atiil@88900");
//		Student s9 = new Student("monu",26,"monu@gmail.com", "Ats@il@88900");
//		Student s10 = new Student("tina",32,"tina@gmail.com", "Anil@88900");
		
		
//		List<Student> asList = Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10);
//		Iterable<Student> saveAll = bean.saveAll(asList);
		 
		
		 
		List<Student> byName = bean.findByName("anil");
		System.out.println(byName.toString());
		
		List<Student> byEmail = bean.findByEmail("dev@gmail.com");
		System.out.println(byEmail.toString());
		
		List<Student> byAge = bean.findByAge(21);
		System.out.println(byAge);
		
		
		
	}

}
