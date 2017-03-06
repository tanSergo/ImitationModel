package sample.environment;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.hardware.Robot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergo on 14.02.2017.
 */
public class Range {
    public static List<List<Point2D>> obstacleRects = new ArrayList<>();
    static final Integer numberOfRobots = 10;
    private static Point2D goalPoint = new Point2D(900,600);
    static final Integer distance = 10;
    static Robot[] robots = new Robot[numberOfRobots];


    private static Point2D[] startPositions = new Point2D[]{
            new Point2D(0, 0),new Point2D(20, 0),
            new Point2D(40, 0),new Point2D(60, 0), new Point2D(80, 0),
            new Point2D(0, 20),new Point2D(20, 20),
            new Point2D(40, 20),new Point2D(60, 20),new Point2D(80, 20)};



    public static void initRange(GraphicsContext context, Integer canvaWidth, Integer canvaHeight) {
        // Отрисовка рамки канвы
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvaWidth, 2);
        context.fillRect(canvaWidth - 2, 0, 2, canvaHeight);
        context.fillRect(0, canvaHeight - 2, canvaWidth, 2);
        // Задание (обозначение) целевой точки на карте
        setGoal(context);
        // Выставление роботов на карту и их инициализация
        setRobots(context, startPositions);
    }

    private static void setRobots(GraphicsContext context,Point2D[] stPositions) {
        initRobots(stPositions,context);
        drawRobots(context,stPositions);
    }

    private static void setGoal(GraphicsContext context) {
        context.setFill(Color.RED);
        drawRect(context, goalPoint);
    }

    private static void initRobots(Point2D[] stPositions, GraphicsContext context) {
        for (int i=0;i<stPositions.length;i++){
            robots[i] = new Robot(i, stPositions[i], context, goalPoint);
        }
    }

    private static void drawRobots(GraphicsContext context, Point2D[] stPositions) {
        context.setFill(Color.FORESTGREEN);
        for (Point2D stPosition : stPositions) {
            drawRect(context, stPosition);
        }
// Посмотреть цели можно раскомментиорвав нижеследующее
/*
        context.setFill(Color.BURLYWOOD);
        for (int i=0;i<stPositions.length;i++){
            drawRect(context, robots[i].getGoalPoint());
        }
*/
    }

    public static void drawRect(GraphicsContext context, Point2D Position) {
//        context.fillOval(Position.getX(), Position.getY(), 10, 10);
        context.fillRect(Position.getX(), Position.getY(), 10, 10);
    }

}


