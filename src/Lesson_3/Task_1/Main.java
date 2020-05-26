package Lesson_3.Task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		String[] str = new String[]{"window", "ball", "sky", "horse", "pen", "ball", "sky", "window", "ball", "sky",
				"horse", "pen", "ball", "sky", "window", "ball", "sky", "horse", "pen", "ball", "sky"};

		uniqWord(str);
	}

	public static void uniqWord(String[] arr) {
		Map<String, Integer> hm = new HashMap<>();

		for (String s : arr) {
			Integer count = hm.get(s);
			hm.put(s, count == null ? 1 : count + 1);
		}

		System.out.println(hm.keySet());
		System.out.println(hm);
	}
}
