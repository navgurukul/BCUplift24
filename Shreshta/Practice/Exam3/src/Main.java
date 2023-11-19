import org.uplift.exam3.Player;
import org.uplift.exam3.SelectionComittee;
import org.uplift.exam3.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Player p1Batter = new Player("Sachin", 40, "Maharashtra");
        Player p2Batter = new Player("Virat", 35, "Delhi");
        Player p3Batter = new Player("Amit", 18, "Gujarat");
        Player p4Batter = new Player("Rajesh", 30,"Gujarat");
        Player p5Batter = new Player("Harvinder", 33,"Haryana");
        Player p6Batter = new Player("Abhi", 33 ,"Delhi");
        Player p7Batter = new Player("Srikanth" , 23, "Tamilnadu");
        Player p8Batter = new Player("Shankar", 23,"Tamilnadu");
        Player p9Batter = new Player("Sudan", 22, "Karnataka");
        Player p1Bowler = new Player("Jaspreet", 28 , "Gujarat");
        Player p2Bowler = new Player("Ashwin", 34, "Karnataka");
        Player p3Bowler = new Player("Ajit", 25, "Delhi");
        Player p4Bowler = new Player("Ravinder", 23 , "Delhi");
        Player p5Bowler = new Player("Amar", 29, "Delhi");
        Player p6Bowler = new Player("Mohinder", 20, "Punjab");
        Player p7Bowler = new Player("Rachin", 27, "Karnataka");
        Player p8Bowler = new Player("Amar", 31, "Haryana");
        Player p9Bowler = new Player("Ajit", 32,"Maharashtra");
        Player p10Bowler = new Player("Rohit", 22, "UP");

        Statistics p1 = new Statistics(300,15000);
        Statistics p2 = new Statistics(250,12000);
        Statistics p3 = new Statistics(45,3000);
        Statistics p4 = new Statistics(100,5000);
        Statistics p5 = new Statistics(100,5000);
        Statistics p6 = new Statistics(100, 7000);
        Statistics p8= new Statistics(30,2000);
        Statistics p9 = new Statistics(100,5000);
        Statistics p10 = new Statistics(55,3000);
        Statistics p11 = new Statistics(150,300);
        Statistics p12 = new Statistics(300,450);
        Statistics p13 = new Statistics(100,100);
        Statistics p14 = new Statistics(80,120);
        Statistics p15 = new Statistics(120,150);
        Statistics p16 = new Statistics(70,100);
        Statistics p17 = new Statistics(40,150);
        Statistics p18 = new Statistics(180,150);
        Statistics p19 = new Statistics(200,350);
        Statistics p20 = new Statistics(100,130);

        Map<Player, Statistics> batterMap = new HashMap<>();
        batterMap.put(p1Batter,p1);
        batterMap.put(p2Batter,p2);
        batterMap.put(p3Batter,p3);
        batterMap.put(p4Batter,p4);
        batterMap.put(p5Batter,p5);
        batterMap.put(p6Batter,p6);
        batterMap.put(p7Batter,p8);
        batterMap.put(p8Batter,p9);
        batterMap.put(p9Batter,p10);

        Map<Player, Statistics> bowlerMap = new HashMap<>();
        bowlerMap.put(p1Bowler,p11);
        bowlerMap.put(p2Bowler,p12);
        bowlerMap.put(p3Bowler,p13);
        bowlerMap.put(p4Bowler,p14);
        bowlerMap.put(p5Bowler,p15);
        bowlerMap.put(p6Bowler,p16);
        bowlerMap.put(p7Bowler,p17);
        bowlerMap.put(p8Bowler,p18);
        bowlerMap.put(p9Bowler,p19);
        bowlerMap.put(p10Bowler,p20);
        System.out.println(batterMap);

        SelectionComittee setestBatter = new SelectionComittee((Set<Player>) batterMap, (Set<Player>) bowlerMap);
        System.out.println(setestBatter);
    }
}
