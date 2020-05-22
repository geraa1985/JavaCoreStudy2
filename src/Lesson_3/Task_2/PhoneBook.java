package Lesson_3.Task_2;

import java.util.*;

public class PhoneBook {

	static Map<String, HashSet<String>> phoneBook = new HashMap<>();

	static void add(String surname, String phoneNumber) {
		HashSet<String> number = new HashSet<>();
		number.add(phoneNumber);
		if (phoneBook.get(surname) != null) {
			number.addAll(phoneBook.get(surname));
		}
		phoneBook.put(surname, number);
	}

	static void get(String s) {
		System.out.print(s + ":  \t");
		for (String n: phoneBook.get(s)) {
			System.out.print(n + ", ");
		}
		System.out.println();
	}

	static void get() {
		phoneBook.forEach((k, v) -> {
			System.out.print(k + ":  \t");
			for (String s: v) {
				System.out.print(s + ", ");
			}
			System.out.println();
		});
	}

}
