package sample.algorithms;

import javafx.geometry.Point2D;

/**
 * Created by Sergo on 15.02.2017.
 */
public interface Algorithm {

    public static Point2D newPosition(Point2D currentXY, Point2D gp, Integer id){return null;};

    public static Point2D lineTrajectory(Point2D xy, Point2D goalPoint){return null;};

    public static Double getXforLine(Point2D xy, Point2D gp){return null;};
}
