package Lesson_1.Obstacle;

import Lesson_1.competitors.Competitor;

public class Cross extends Obstacle {

    private int dist;

    public Cross(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(dist);
    }
}
