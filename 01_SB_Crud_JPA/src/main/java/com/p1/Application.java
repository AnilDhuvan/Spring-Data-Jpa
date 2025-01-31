package com.p1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.p1.entity.User;
import com.p1.service.UserServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		UserServiceImpl bean = context.getBean(UserServiceImpl.class);
		
		
//		boolean userSave = bean.userSave("anil", "anil@gmail.com", "9929@Dev");
//		
//		if(userSave == true) {
//			System.out.println("userRecord insert Succfully");
//		}else {
//			System.out.println("user Record not insert ");
//		}
		
		
//		boolean allUserSave = bean.AllUserSave();
		
		
//		Optional<User> byId = bean.findById(1);
//		System.out.println(byId);
		
		
//		Iterable<User> allById = bean.findAllById(1,2,3,4,5,6);
//		System.out.println(allById);
		
		
//		Iterable<User> all = bean.findAll();
//		System.out.println(all);
		
		
//		boolean existsById = bean.userExistsById(1);
//		System.out.println(existsById);
		
		
//		Long userCount = bean.userCount();
//		System.out.println(userCount);
		
		
//		bean.userDeleteById(1);
		
//		bean.userDelete(2,3,4,5,6);
		
//		bean.AllUserDelete();
		
		
	}

}
