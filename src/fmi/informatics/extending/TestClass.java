package fmi.informatics.extending;

import java.util.ArrayList;

import fmi.informatics.composition.RichStudent2;

public class TestClass {

	//Добавяне на хора от тип Student, RichStudent2 и Professor в ArrayList
	public static void addPeople(ArrayList<Person> people) {
		people.add(new Student("Pesho", 123, "PU", "5698", 2569));
		people.add(new RichStudent2("Vasil", 6266, "PU", "BIT", 5345));
		people.add(new RichStudent2("Vasil", 6266, "PU", "BIT", 5345));
		people.add(new Professor("Professor", "Ivan", true, 40, 180, 75));
		people.add(new RichStudent2("Gosho", 456, "SU", "Informatika", 3123));
		people.add(new Student("Tosho", 567, "VTU", "6346", 7675));
		people.add(new Professor("Professor", "Petur", true, 30, 175, 70));
		people.add(new Professor("Professor", "Petur", true, 30, 175, 70));
		people.add(new RichStudent2("Vasil", 6266, "PU", "BIT", 5345));
		people.add(new Professor("Professor", "Petur", true, 30, 175, 70));
		people.add(new Professor("Professor", "Petur", true, 30, 175, 70));
	}

	public static void showStats(ArrayList<Person> people) {

		// Проверка на тип Class.
		int stuCounter = 0, profCounter = 0, richCounter = 0;
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i) instanceof RichStudent2) {
				System.out.println("I'm a rich student of type " + people.get(i).getClass().getSimpleName());
				richCounter++;

			} else if (people.get(i) instanceof Professor) {
				System.out.println("I'm a professor of type " + people.get(i).getClass().getSimpleName());
				profCounter++;
			} else {
				System.out.println("I'm a student of type " + people.get(i).getClass().getSimpleName());
				stuCounter++;
			}
		}

		// Статистика и общ брой хора.
		System.out.println("\nThe number of students are: " + stuCounter + "\nThe number of professors are: "
				+ profCounter + "\nThe number of rich students are: " + richCounter);
		System.out.println("\nThe total people here are: " + (stuCounter + profCounter + richCounter) + "\n");

		// Извиква метода study() на хора от тип Student и RichStudent2.
		for (int i = 0; i < people.size(); i++) {
			if (!(people.get(i) instanceof Professor)) {
				people.get(i).study();
			}
		}
	}

	// Създаване на анонимен клас
	public static void testAnonymousClass() {

		Student student = new Student("Pesho", 123, "PU", "5698", 2569) {

			@Override
			public void study() {
				System.out.println("\nThe student is studying at the moment.");
			}

			@Override
			public void think() {
				System.out.println("\nThe student is thinking of a way to do his homework.");
			}

			@Override
			public void act() {
				System.out.println("\nThe student is acting at the moment.");
			}
		};
		student.study();
		student.think();
		student.act();
	}

	// Тестване на методите Class.forName() и Class.newInstance().
	public static void testClassInstance()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class<?> studentForName = Class.forName(Student.class.getName());
		System.out.println("\nThe student's class forName is: " + studentForName);
		Student studentInstance = (Student) studentForName.newInstance();
		studentInstance.takeExam();

	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ArrayList<Person> people = new ArrayList<>();

		addPeople(people);		
		showStats(people);
		testAnonymousClass();
		testClassInstance();
	}
}