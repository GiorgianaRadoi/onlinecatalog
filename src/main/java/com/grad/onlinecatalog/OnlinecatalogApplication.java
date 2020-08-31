package com.grad.onlinecatalog;

import com.grad.onlinecatalog.repository.StudentRepository;
import com.grad.onlinecatalog.service.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinecatalogApplication implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SendGridEmailService sendGridEmailService;

	public static void main(String[] args) {
		SpringApplication.run(OnlinecatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		sendGridEmailService.sendHTML("giorgiana.radoi1@gmail.com", "giorgiana.radoi1@gmail.com", "Hello from the other side!", "Hello!");
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
}
