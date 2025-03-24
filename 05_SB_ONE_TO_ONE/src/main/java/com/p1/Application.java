package com.p1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.p1.service.PersonPassportService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		PersonPassportService bean = context.getBean(PersonPassportService.class);
		// bean.saveData();

		// bean.getPerson();

		// bean.getPassport();
		
		// bean.deletePerson();
		
		bean.deletePassport();
	}

}
