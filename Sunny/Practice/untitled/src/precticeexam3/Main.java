package precticeexam3;

import java.util.HashMap;
import java.util.*;

public class Main {
    public static  void main(String[] input) {
        Player batsmen1 = new Player("Virat", 35, "Delhi ");
        Statistics batsmen1stats = new Statistics(250, 12000);
        Player batsmen2 = new Player("Sachin",40,"Maharashtra");
        Statistics batsmen2stats = new Statistics(300,15000);
        Player batsmen3 = new Player("Amit",18,"Gujarat");
        Statistics batsmen3stats = new Statistics(45,3000);
        Player batsmen4 = new Player("Rajesh",30,"Gujarat");
        Statistics batsmen4stats = new Statistics(100,5000);
        Player batsmen5 = new Player("Harvinder",33,"Haryana");
        Statistics batsmen5stats = new Statistics(100,5000);


        Player bowler1 = new Player("Jasprit Bumrah",28,"Gujarat");
        Statistics bowler1stats = new Statistics(150,300);
        Player bowler2 = new Player("Ashwin",34,"Karnataka");
        Statistics bowler2stats = new Statistics(300,450);
        Player bowler3 = new Player("Ravinder",23,"Delhi");
        Statistics bowler3stats = new Statistics(80,120);
        Player bowler4 = new Player("Amar",29,"Delhi");
        Statistics bowler4stats = new Statistics(120,150);
        Player bowler5 = new Player("Rachin",27,"Karnataka");
        Statistics bowler5stats = new Statistics(40,150);

        HashMap<Player, Statistics> batsmenMap = new HashMap<>();
        HashMap<Player, Statistics> bowlersMap = new HashMap<>();
        batsmenMap.put(batsmen1,batsmen1stats);
        batsmenMap.put(batsmen2,batsmen2stats);
        batsmenMap.put(batsmen3,batsmen3stats);
        batsmenMap.put(batsmen4,batsmen4stats);
        batsmenMap.put(batsmen5,batsmen5stats);
        bowlersMap.put(bowler1,bowler1stats);
        bowlersMap.put(bowler2,bowler2stats);
        bowlersMap.put(bowler3,bowler3stats);
        bowlersMap.put(bowler4,bowler4stats);
        bowlersMap.put(bowler5,bowler5stats);


        SelectionCommittee newobj = new SelectionCommittee(batsmenMap,bowlersMap);

        System.out.println(newobj.getSelectedBatters());
        System.out.println(newobj.getSelectedBowler());
    }
}
