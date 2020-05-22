package Lesson_2;

public class MyArrayDataException extends RuntimeException {
	private int i;
	private int j;

	public MyArrayDataException(String s, int i, int j) {
		super(s);
		this.i = i;
		this.j = j;
	}

	public void info(){
		System.out.println("Неприемлемый элемент в строке под индексом " + i + " , в столбце под индексом " + j);
	}
}
