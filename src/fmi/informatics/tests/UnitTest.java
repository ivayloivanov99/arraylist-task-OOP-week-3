package fmi.informatics.tests;

import fmi.informatics.extending.Student;

public class UnitTest {

	//Проверка на университет
	public static void testStudentUniversity(Student student) {
		String expectedUniversity = "PU";
		String resultUniversity = student.getUniversity();
		
		if (assertString(resultUniversity, expectedUniversity)) {
			System.out.println("The student is studying at Plovdiv University");
		} else {
			System.out.println(
					"The student is not studying at " +	expectedUniversity 
					+ ", but is studying at " + resultUniversity);
		}
	}
	//Проверка на специалност
	public static void testStudentSpeciality(Student student) {
		String expectedSpeciality = "Informatika";
		String resultSpeciality = student.getSpeciality();
		
		if (assertString(resultSpeciality, expectedSpeciality)) {
			System.out.println("\nThe student is studying Informatika");
		} else {
			System.out.println(
					"The student is not studying " + expectedSpeciality 
					+ ", but is studying " + resultSpeciality);
		}
	}
		
	public static boolean assertString(String result, String expectedResult) {
		return result.equals(expectedResult);
	}
}
