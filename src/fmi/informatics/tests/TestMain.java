package fmi.informatics.tests;

import fmi.informatics.extending.Student;

public class TestMain {

	public static void main(String[] args) {
		Student student = new Student("Pesho", 123, "PU", "Informatika", 2569);
		Student student2 = new Student("Tosho", 567, "VTU", "Matematika", 7675);

		//Тестване на университет
		UnitTest.testStudentUniversity(student);
		UnitTest.testStudentUniversity(student2);

		//Тестване на специалност
		UnitTest.testStudentSpeciality(student);
		UnitTest.testStudentSpeciality(student2);

	}

}
