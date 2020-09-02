package com.grad.onlinecatalog;

import com.grad.onlinecatalog.config.StorageProperties;
import com.grad.onlinecatalog.model.Student;
import com.grad.onlinecatalog.repository.PendingUserRepository;
import com.grad.onlinecatalog.repository.StudentRepository;
import com.grad.onlinecatalog.repository.UserRepository;
import com.grad.onlinecatalog.service.SendGridEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class OnlinecatalogApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private PendingUserRepository pendingUserRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SendGridEmailService sendGridEmailService;

	public static void main(String[] args) {
		SpringApplication.run(OnlinecatalogApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(StorageService storageService) {
//		return (args) -> {
//			storageService.deleteAll();
//			storageService.init();
//		};
//
//	}

	@Override
	public void run (String...args) throws Exception {
		try {
			userRepository.deleteById( 1 );
		} catch (Exception ex) {
		}

	}


		//sendGridEmailService.sendHTML("buhaidebalta.15@gmail.com", "buhaidebalta.15@gmail.com", "Hello from the other side!", "Hello!");
//		Student student = new Student();
//		student.setFirstName("John");
//		student.setLastName("Doe");
//
//		Student student2 = new Student();
//		student2.setFirstName("John");
//		student2.setLastName("Doe");
//
//		studentRepository.save(student);
//		studentRepository.save(student2);
//
//		System.out.println("*************before delete*****************");
//		for (Student s: studentRepository.findAll()) {
//			System.out.println(s.getStudentId() + ". " + s.getFirstName() + " " + s.getLastName());
//		}
//
//		System.out.println("*************after delete*****************");
//		studentRepository.deleteById(2);
//		for (Student s: studentRepository.findAll()) {
//			System.out.println(s.getStudentId() + ". " + s.getFirstName() + " " + s.getLastName());
//		}

	}



