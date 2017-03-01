package sample.hardware;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.Range;
import sample.algorithms.Algorithm;
import sample.algorithms.LineOnly;

import java.util.ArrayList;
import java.util.List;

import static sample.algorithms.LineOnly.newPosition;

/**
 * Created by Sergo on 08.10.2016.
 */
public class Robot {
    private Point2D myXY;
    private Point2D newXY;
    private Integer id;
    private GraphicsContext context;
    private Point2D goalPoint;

    public Robot(Integer i, Point2D XY, GraphicsContext context, Point2D gp) {
        this.myXY = XY;
        this.id = i;
        this.context = context;
        this.goalPoint = new Point2D(
                gp.getX() + (id%5)*20,
                gp.getY() + (id/5)*20
        );
    }

    public void setMyXY(Point2D XY) {
        this.myXY = XY;
    }

    public Point2D getMyXY() {
        return myXY;
    }

    private Point2D getGoalPoint() {
        return goalPoint;
    }

    public void takeNewXY(){
        this.setNewXY(newPosition(getMyXY(), getGoalPoint(), id));
    }

    private void setNewXY(Point2D newXY) {
        this.newXY = newXY;
    }

    private Point2D getNewXY() {
        return newXY;
    }

    public void renewPositionOnRange() {
        context.clearRect(myXY.getX(), myXY.getY(), 10, 10);
        context.setFill(Color.FORESTGREEN);
        Range.drawRect(context, newXY);
        setMyXY(newXY);
    }

/*
    private class RangeSensor {
        public final Integer radius = 20;

        public List<Point2D> lookAround(){
            List<Point2D> obstacles = new ArrayList<>();
            for (int i = 0; i< Range.obstacleRects.size(); i++){

                if (Range.obstacleRects.get(i).get(0).getX() <= (myXY.getX() + radius)// 1 условие
                        && Range.obstacleRects.get(i).get(0).getY() <= (myXY.getY() + radius) // 2 условие
                        && Range.obstacleRects.get(i).get(0).getX() >= myXY.getX() - radius // 3 условие
                        && Range.obstacleRects.get(i).get(0).getY() >= myXY.getY() - radius // 4 условие
                        ) {
                    obstacles.add(new Point2D(Range.obstacleRects.get(i).get(0).getX()
                            , Range.obstacleRects.get(i).get(0).getY()));
                }


                if (Range.obstacleRects.get(i).get(1).getX() <= (myXY.getX() + radius)// 1 условие
                        && Range.obstacleRects.get(i).get(0).getY() <= (myXY.getY() + radius) // 2 условие
                        && Range.obstacleRects.get(i).get(1).getX() >= myXY.getX() - radius // 3 условие
                        && Range.obstacleRects.get(i).get(0).getY() >= myXY.getY() - radius // 4 условие
                        ) {
                    obstacles.add(new Point2D(Range.obstacleRects.get(i).get(1).getX()
                            , Range.obstacleRects.get(i).get(0).getY()));
                }


                if (Range.obstacleRects.get(i).get(0).getX() <= (myXY.getX() + radius)// 1 условие
                        && Range.obstacleRects.get(i).get(1).getY() <= (myXY.getY() + radius) // 2 условие
                        && Range.obstacleRects.get(i).get(0).getX() >= myXY.getX() - radius // 3 условие
                        && Range.obstacleRects.get(i).get(1).getY() >= myXY.getY() - radius // 4 условие
                        ) {
                    obstacles.add(new Point2D(Range.obstacleRects.get(i).get(0).getX()
                            , Range.obstacleRects.get(i).get(1).getY()));
                }


                if (Range.obstacleRects.get(i).get(1).getX() <= (myXY.getX() + radius)// 1 условие
                        && Range.obstacleRects.get(i).get(1).getY() <= (myXY.getY() + radius) // 2 условие
                        && Range.obstacleRects.get(i).get(1).getX() >= myXY.getX() - radius // 3 условие
                        && Range.obstacleRects.get(i).get(1).getY() >= myXY.getY() - radius // 4 условие
                        ) {
                    obstacles.add(new Point2D(Range.obstacleRects.get(i).get(1).getX()
                            , Range.obstacleRects.get(i).get(1).getY()));
                }
            }
            return obstacles;
        }
    }
*/
}
