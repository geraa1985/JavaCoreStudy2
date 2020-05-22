package Lesson_3.Task_2;


public class Main {
	public static void main(String[] args) {

		PhoneBook.add("Иванов", "+7 (999) 349-99-76");
		PhoneBook.add("Петров", "+7 (925) 684-67-34");
		PhoneBook.add("Сидоров", "+7 (234) 456-23-12");
		PhoneBook.add("Иванов", "+7 (545) 654-88-67");
		PhoneBook.add("Рыжиков", "+7 (456) 346-66-66");
		PhoneBook.add("Чижиков", "+7 (567) 345-88-43");
		PhoneBook.add("Иванов", "+7 (876) 543-43-22");

		PhoneBook.get("Иванов");
		System.out.println();

		PhoneBook.get();
	}

}
