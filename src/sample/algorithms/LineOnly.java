package sample.algorithms;

import javafx.geometry.Point2D;

/**
 * Created by Sergo on 25.02.2017.
 */
public class LineOnly implements Algorithm {

    public static Point2D newPosition(Point2D currentXY, Point2D gp, Integer id) {
        return lineTrajectory(currentXY, gp);
    }


    public static Double getXforLine(Point2D xy, Point2D gp) {
        Double X;
        Double delta = gp.getX() - xy.getX();
        if (delta > 0)
            X = (delta < 5) ? gp.getX() : (xy.getX() + 5.0);
        else
            X = (delta > -5) ? gp.getX() : (xy.getX() - 5.0);
        return X;
    }


    public static Point2D lineTrajectory(Point2D xy, Point2D goalPoint) {
        Double X = getXforLine(xy, goalPoint);
        Double Y;
        if (X != xy.getX())
            Y = (X - xy.getX())*(goalPoint.getY() - xy.getY())/(goalPoint.getX() - xy.getX()) + xy.getY();
        else Y = (goalPoint.getY() - xy.getY())>0 ? xy.getY() + 5 : xy.getY() - 5;
        return new Point2D(X, Y);
    }
}
