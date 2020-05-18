package Lesson_1;

import Lesson_1.Obstacle.Cross;
import Lesson_1.Obstacle.Obstacle;
import Lesson_1.Obstacle.Wall;
import Lesson_1.competitors.Cat;
import Lesson_1.competitors.Competitor;
import Lesson_1.competitors.Human;
import Lesson_1.competitors.Robot;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {
                new Human("Bob"),
                new Cat("Barsik"),
                new Robot("Android"),
                new Human("John Connor",10000, 4)
        };

        Obstacle[] obstacles = {
                new Cross(15000),
                new Wall(1)
        };

        for (Competitor c:competitors ) {
            for (Obstacle o:obstacles ) {
                o.doIt(c);
                if(!c.isOnDistance()){
                    break;
                }
            }
        }
        System.out.println();
        for (Competitor c:competitors ) {
            c.info();
        }

    }
}
