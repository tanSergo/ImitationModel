package sample;

import sample.algorithms.Algorithm;
import sample.algorithms.LineOnly;

/**
 * Created by Sergo on 15.02.2017.
 */
public class Sheduler {

    static void nextStep(){
//        System.out.println("Button pressed!");
        for (int i=0;i<Range.numberOfRobots;i++){
            Range.robots[i].takeNewXY();
            Range.robots[i].renewPositionOnRange();
        }
    }
}
