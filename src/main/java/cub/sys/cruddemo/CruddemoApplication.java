package cub.sys.cruddemo;

import cub.sys.cruddemo.dao.studentDAO;
import cub.sys.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(studentDAO mstudent){
		return  runner -> {
			System.out.println("hello world");
			//createStudent(mstudent);

			//readStudent(mstudent);

			//queryForStudent(mstudent);

			//queryByLastName(mstudent);

			//updateStudent(mstudent);


			deleteStudent(mstudent);
		};
	}

	private void deleteStudent(studentDAO mstudent) {

		int studentID =3;
		mstudent.deleteById(studentID);
	}

	private void updateStudent(studentDAO mstudent) {

		int Id = 1;

		Student m = mstudent.findById(Id);

		m.setFirstName("Chile");;

		mstudent.update(m);
	}

	private void queryByLastName(studentDAO mstudent) {
		List<Student> studentList = mstudent.findByLastName("ekpei");


		for(Student m : studentList){
			System.out.println(m);
		}
	}

	private void queryForStudent(studentDAO mstudent) {

		List<Student> studentList = mstudent.findAll();


		for(Student m : studentList){
			System.out.println(m);
		}
	}

	private void readStudent(studentDAO mstudent) {

		///create new student
		System.out.println("creating students.....");

		///get the student id
		Student tempStudent =new Student("police", "war", "w@gmail.com");


		mstudent.save(tempStudent);

		int theID = tempStudent.getId();

		System.out.println("Student id :"+ theID);


		///retrieve the student with the id

		Student theStudent = mstudent.findById(theID);

		System.out.println("getting the saved student"+ theStudent);

	}

	private void createStudent(studentDAO mstudent) {

		System.out.println("creating students");

		Student tempStudent = new Student("Solomon", "Akin", "s@gmail.com");
		Student tempStudent2 = new Student("Francis", "Razeed", "r@gmail.com");



		System.out.println("saving students/.......");

		mstudent.save(tempStudent);
		mstudent.save(tempStudent2);

		System.out.println("Generated Student ID:" + tempStudent.getId());
	}

}
