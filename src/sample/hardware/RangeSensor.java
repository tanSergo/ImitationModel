package sample.hardware;

import javafx.geometry.Point2D;
import sample.environment.Range;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Sergo on 01.03.2017.
 */
public class RangeSensor {

    public List<Point2D> lookAround(Point2D myXY){
        List<Point2D> obstacles = new ArrayList<>();
        Integer radius = 20;
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
