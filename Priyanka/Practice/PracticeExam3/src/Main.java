import org.cricket.Player;
import org.cricket.SelectionCommitee;
import org.cricket.StackManger;
import org.cricket.Statistic;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Player s1 = new Player("Rohit",38,"Maharashtra");
        Player s2 = new Player("Chahal",32,"MadhyaPradesh");

        Statistic sc1 = new Statistic(45,2340);
        Statistic sc1 = new Statistic(30,23);
        StackManger sm = new StackManger();
        SelectionCommitee sc = new SelectionCommitee();

        sc.calculateBatsmanPerformance(sm.getListOfPlayer(),s1.getAge(),s1.getState());
        sc.calculateBowlerPerformance(sm.getListOfPlayer(),s2.getAge(),s2.getState());

        

    }
}