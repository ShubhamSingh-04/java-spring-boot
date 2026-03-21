package com.shubham.jpa_hibernate;

import com.shubham.jpa_hibernate.dao.StudentDAO;
import com.shubham.jpa_hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating student object");
		Student temp = new Student("Shubham", "Singh", "shubhamsinghmyss@gmail.com");

		// save the student object
		studentDAO.save(temp);

		// display id of the saved student
		System.out.println("Saved Student id: "+ temp.getId());
	}

}
