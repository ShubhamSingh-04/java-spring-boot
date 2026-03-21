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
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);

			findStudentById(studentDAO, 2);
		};
	}

	private void findStudentById(StudentDAO studentDAO, int id) {
		System.out.println("Fetching the record with id: " + id);
		Student student = studentDAO.findById(id);

		if(student != null)
			System.out.println(student);
		else
			System.out.println("No Student found with id: " + id);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student temp = new Student("John", "Kennedy", "jk@gmail.com");

		Student temp2 = new Student("Ana", "De Armas", "ana@gmail.com");

		Student temp3 = new Student("Tyrion", "Lannister", "lannister@gmail.com");

		System.out.println("Saving Multiple objects");

		studentDAO.save(temp);
		studentDAO.save(temp2);
		studentDAO.save(temp3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating student object");
		Student temp = new Student("Shubham", "Singh", "shubhamsinghmys@gmail.com");

		// save the student object
		studentDAO.save(temp);

		// display id of the saved student
		System.out.println("Saved Student id: "+ temp.getId());
	}

}
