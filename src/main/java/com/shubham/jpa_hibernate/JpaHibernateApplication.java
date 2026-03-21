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

//			findStudentById(studentDAO, 2);

//			findAllStudents(studentDAO);

//			findStudentByFname(studentDAO, "Shubham");

//			updateStudent(studentDAO, 2);

//			setStudentEmailNull(studentDAO); // set all rows email null

//			deleteStudent(studentDAO, 4);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int rowsAffected = studentDAO.deleteAll();
		System.out.println("Rows Affected: " + rowsAffected);

		System.out.println("deleteAllStudents() executed");
	}

	private void deleteStudent(StudentDAO studentDAO, int id){
//		THIS WILL NOT WORK AS THE STUDENT OBJECT IS DETACHED FROM THE DB
//		studentDAO.delete(
//				findStudentById(studentDAO, 3)
//		);

		int rowsAffected = studentDAO.deleteById(id);
		System.out.println("Rows Affected: " + rowsAffected);

		System.out.println("deleteStudent() executed");
	}

	// updates all rows
	private void setStudentEmailNull(StudentDAO studentDAO)
	{
		int rowsAffected = studentDAO.updateEmailNull();
		System.out.println("Rows Affected: " + rowsAffected);
	}

	private void updateStudent(StudentDAO studentDAO, int id) {
		Student s = findStudentById(studentDAO, id);

		s.setEmail("newEmail@gmail.com");

		studentDAO.update(s);

		findStudentById(studentDAO, id);
	}

	private void findStudentByFname(StudentDAO studentDAO, String fName){
		for(Student s : studentDAO.findByFname(fName)){
			System.out.println(s);
		}
		System.out.println("End of findStudentByFname()");
	}

	private void findAllStudents(StudentDAO studentDAO) {
		for(Student s : studentDAO.findAll()){
			System.out.println(s);
		}
	}

	private Student findStudentById(StudentDAO studentDAO, int id) {
		System.out.println("Fetching the record with id: " + id);
		Student student = studentDAO.findById(id);

		if(student != null)
			System.out.println(student);
		else
			System.out.println("No Student found with id: " + id);


		return student;

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
