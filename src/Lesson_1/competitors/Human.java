package Lesson_1.competitors;

public class Human implements Competitor {
    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;

    private boolean onDistance;


    public Human(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    public Human(String name){
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 2;
        this.onDistance = true;
    }


    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println("Человек " + name + " успешно пробежал " + dist + " метров");
        } else {
            System.out.println("Человек " + name + " не смог пробежать " + dist + " метров");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println("Человек " + name + " успешно перепрыгнул " + height + " метров");
        } else {
            System.out.println("Человек " + name + " не может " + height + " метров прыгнуть");
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println("Человек " + name + " " +
                (onDistance ? " на дистанции" : " выбыл из соревнований"));
    }

}
