package sample.environment;

import sample.environment.Range;

/**
 * Created by Sergo on 15.02.2017.
 */
public class Sheduler {

    public static void nextStep(){
//        System.out.println("Button pressed!");
        for (int i = 0; i< Range.numberOfRobots; i++){
            Range.robots[i].takeNewXY();
            Range.robots[i].renewPositionOnRange();
        }
        Range.statistic.renewStatistic();
        System.out.println("Lost Connection : " + Range.statistic.getLostConnection());
        System.out.println("Steps : " + Range.statistic.getSteps());
    }
}
