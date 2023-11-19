package uplift.practiceexam3;
import java.util.*;
//        6) Abhi, 33 years, Delhi, 100 matches, 7,000 runs
//        7) Rajesh, 33 years, Gujarat, 100 matches, 5,000 runs
//        8) Srikanth, 23 years, Tamilnadu, 30 matches, 2,000 runs
//        9) Shankar, 26 years, Tamilnadu, 100 matches, 5,000 runs
//        10) Sudan, 22 years, Karnataka, 55 matches, 3,000 runs
////        Bowlers:
//        1) Jaspreet, 28 years, Gujarat, 150 matches, 300 wickets
//        2) Ashwin, 34 years, Karnataka, 300 matches, 450 wickets
//        3) Ajit, 25 years, Delhi, 100 matches, 100 wickets
//        4) Ravinder, 23 years, Delhi, 80 matches, 120 wickets
//        5) Amar, 29 years, Delhi, 120 matches, 150 wickets
public class Main {
    public static void main(String[] args) {
        Map<Player, Statistics> batsmanMap = new HashMap<>();
        Map<Player, Statistics> bowlerMap = new HashMap<>();

        Batsman batsman1 = new Batsman("Abhi", 33,  "Delji");
        Batsman batsman2 = new Batsman("virat", 35,  "bihar");
        Bowler bowler1 = new Bowler("varma",34 ,"karnataka");
        Bowler bowler2 = new Bowler("rahul", 28,  "maharastra");

        batsmanMap.put(batsman1, new Statistics(50, 2500));
        batsmanMap.put(batsman2, new Statistics(40, 1800));
        bowlerMap.put(bowler1, new Statistics(60, 150));
        bowlerMap.put(bowler2, new Statistics(30, 80));

        // Accessing stats for batsmen
        for (Map.Entry<Player, Statistics> entry : batsmanMap.entrySet()) {
            Player player = entry.getKey();
            Statistics stats = entry.getValue();
            System.out.println("Batsman: " + player.getName() + ", Matches: " + stats.getMatches() + ", Performance: " + stats.getPerformance());
        }

        // Accessing stats for bowlers
        for (Map.Entry<Player, Statistics> entry : bowlerMap.entrySet()) {
            Player player = entry.getKey();
            Statistics stats = entry.getValue();
            System.out.println("Bowler: " + player.getName() + ", Matches: " + stats.getMatches() + ", Performance: " + stats.getPerformance());
        }
    }
}

