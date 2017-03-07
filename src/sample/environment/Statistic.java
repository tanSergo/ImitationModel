package sample.environment;

import javafx.geometry.Point2D;
import sample.hardware.Robot;

import java.util.Objects;

import static java.lang.Math.*;
import static sample.environment.Range.*;

/**
 * Created by Sergo on 02.03.2017.
 */
public class Statistic {

    private Long lostConnection = 0L;
    private Long steps = 0L;
    private final Integer normConnections = (9 * numberOfRobots - 25)/5;

    private void setSteps(Long steps) {
        this.steps = steps;
    }

    public Long getSteps() {
        return steps;
    }

    public Long getLostConnection() {
        return lostConnection;
    }

    private void setLostConnection(Long lostConnection) {
        this.lostConnection = lostConnection;
    }

    void renewStatistic(){
        setSteps(getSteps() + 1);
        if (!Objects.equals(countConnections(), normConnections)) setLostConnection(getLostConnection() + 1);
    }

    private Integer countConnections() {
        Integer connections = 0;
        for (int i = 0; i < numberOfRobots - 1; i++){
            for (int j = i + 1; j < numberOfRobots; j++){
                Point2D robot1 = robots[i].getMyXY();
                Point2D robot2 = robots[j].getMyXY();
                if (evaluateDistance(robot1, robot2) < 15.0) connections++;
            }
        }
        return connections;
    }

    private Double evaluateDistance(Point2D r1, Point2D r2) {
        Double dx = r1.getX() - r2.getX();
        Double dy = r1.getY() - r2.getY();
        return sqrt(dx*dx + dy*dy) - 10;
    }
}
