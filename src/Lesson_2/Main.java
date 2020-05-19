package Lesson_2;

public class Main {

	public static void main(String[] args) {
		String[][] arr1 = {{"12", "3", "O", "8"}, {"12", "3", "0", "8"}, {"12", "3", "0", "8"}, {"12", "3", "0", "8"}};

		try {
			int res = sumArr(arr1);
			System.out.println("Сумма всех элементов двумерного массива: " + res);
		} catch (MyArraySizeException e) {
			e.printStackTrace();
			e.info();
		} catch (MyArrayDataException e) {
			e.printStackTrace();
			e.info();
		}
	}

	public static int sumArr(String[][] arr) {
		if (arr.length != 4) {
			throw new MyArraySizeException();
		}

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].length != 4) {
				throw new MyArraySizeException();
			}
		}

		int k = 0;


		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				try {
					k += Integer.parseInt(arr[i][j]);
				} catch (RuntimeException e) {
					throw new MyArrayDataException("Неприемлемое значение массива", i, j);
				}
			}
		}

		return k;
	}
}
