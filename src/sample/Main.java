package sample;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.environment.Range;
import sample.environment.Sheduler;

import java.util.ArrayList;

public class Main extends Application {

    static final  Integer sceneWidth = 1250;
//    static final Integer sceneHeight = 1000;
static final Integer sceneHeight = 700;

    final static Integer canvaWidth = sceneWidth - 120;
    final static Integer canvaHeight = sceneHeight - 30;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*final Integer sceneWidth = 1250;
        final Integer sceneHeight = 1000;

        final Double canvaWidth = sceneWidth - 120.D;
        final Double canvaHeight = sceneHeight.doubleValue() - 30;*/
//        final Integer sceneWidth = 700;
//        final Integer sceneHeight = 700;

//        public List<List<Point2D>> obstacleRects = new ArrayList<>();

        primaryStage.setTitle("Полигон");
        Group root = new Group();
        Scene scene = new Scene(root, sceneWidth, sceneHeight, Color.GHOSTWHITE);
        primaryStage.setScene(scene);
        primaryStage.show();


        Canvas canvas = new Canvas(canvaWidth, canvaHeight); // создаем новый объект Canvas с шириной 300px, и высотой 275px
        root.getChildren().add(canvas); // добавляем его в корневой контейнер
        GraphicsContext context = canvas.getGraphicsContext2D();


        ScrollPane sp = new ScrollPane();
        sp.setLayoutX(10);

        sp.setContent(canvas);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        sp.setPrefViewportHeight(canvaHeight);
        sp.setPrefViewportWidth(canvaWidth);
        root.getChildren().add(sp);



        Button btnS=new Button("Step");
        btnS.setLayoutX(canvaWidth + 30);
        btnS.setLayoutY(20);
        btnS.setStyle("-fx-font: 16pt Arial;");
        root.getChildren().add(btnS);

        btnS.setOnAction(e -> {

                Sheduler.nextStep();
        });

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                e -> {
                    Range.obstacleRects.add(new ArrayList<>());
                    Range.obstacleRects.get(Range.obstacleRects.size()-1).add(new Point2D(e.getX(),e.getY()));
                });
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
                e -> {
                    context.setFill(Color.BLUE);
                    Range.obstacleRects.get(Range.obstacleRects.size()-1).add(new Point2D(e.getX(),e.getY()));

                    context.fillRect(Range.obstacleRects.get(Range.obstacleRects.size()-1).get(0).getX(),
                            Range.obstacleRects.get(Range.obstacleRects.size()-1).get(0).getY(),
                            Range.obstacleRects.get(Range.obstacleRects.size()-1).get(1).getX()
                                    -Range.obstacleRects.get(Range.obstacleRects.size()-1).get(0).getX(),
                            Range.obstacleRects.get(Range.obstacleRects.size()-1).get(1).getY()
                                    -Range.obstacleRects.get(Range.obstacleRects.size()-1).get(0).getY());
                });


// Инициализация карты
        Range.initRange(context, canvaWidth, canvaHeight);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
