package Lesson_1.competitors;

public class Robot implements Competitor {
	private String name;

	private int maxRunDistance;
	private int maxJumpHeight;

	private boolean onDistance;


	public Robot(String name, int maxRunDistance, int maxJumpHeight) {
		this.name = name;
		this.maxRunDistance = maxRunDistance;
		this.maxJumpHeight = maxJumpHeight;
		this.onDistance = true;
	}

	public Robot(String name){
		this.name = name;
		this.maxRunDistance = 20000;
		this.maxJumpHeight = 1;
		this.onDistance = true;
	}


	@Override
	public void run(int dist) {
		if (dist <= maxRunDistance) {
			System.out.println("Робот " + name + " успешно пробежал " + dist + " метров");
		} else {
			System.out.println("Робот " + name + " не смог пробежать " + dist + " метров");
			onDistance = false;
		}
	}

	@Override
	public void jump(int height) {
		if (height <= maxJumpHeight) {
			System.out.println("Робот " + name + " успешно перепрыгнул " + height + " метров");
		} else {
			System.out.println("Робот " + name + " не может " + height + " метров прыгнуть");
			onDistance = false;
		}
	}

	@Override
	public boolean isOnDistance() {
		return onDistance;
	}

	@Override
	public void info() {
		System.out.println("Робот " + name + " " +
				(onDistance ? " на дистанции" : " выбыл из соревнований"));
	}

}