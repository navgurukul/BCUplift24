package org.playerRecords;

import java.util.HashMap;
import java.util.Map;

public class StatsManager {
    private Map<Player, Statistics> batsmans = new HashMap<>();
    private Map<Player, Statistics> bowlers = new HashMap<>();

    public StatsManager(){
        generateBatsmanRecords();
        generateBowlersRecords();
    }

    private void generateBatsmanRecords(){
        // all batsman
        Player bat1 = new Player("Sachin", 40, "Maharashtra");
        Player bat2 = new Player("Virat", 30, "Delhi");
        Player bat3 = new Player("Amit", 30, "Gujarat");
        Player bat4 = new Player("Rajesh", 30, "Gujarat");
        Player bat5 = new Player("Harvinder", 33, "Haryana");
        Player bat6 = new Player("Abhi", 33, "Delhi");
        Player bat7 = new Player("Rajesh", 33, "Gujarat");
        Player bat8 = new Player("Srikanth", 23, "Tamilnadu");
        Player bat9 = new Player("Shankar", 26, "Tamilnadu");
        Player bat10 = new Player("Sudan", 22, "Karnataka");

        // All Batsman Statistic

        Statistics bat1S = new Statistics(300.0, 15000);
        Statistics bat2S = new Statistics(250.0, 12000);
        Statistics bat3S = new Statistics(45.0, 3000);
        Statistics bat4S = new Statistics(100.0, 5000);
        Statistics bat5S = new Statistics(100.0, 5000);
        Statistics bat6S = new Statistics(100.0, 7000);
        Statistics bat7S = new Statistics(100.0, 5000);
        Statistics bat8S = new Statistics(30.0, 2000);
        Statistics bat9S = new Statistics(100.0, 5000);
        Statistics bat10S = new Statistics(55.0, 3000);

        batsmans.put(bat1, bat1S);
        batsmans.put(bat2, bat2S);
        batsmans.put(bat3, bat3S);
        batsmans.put(bat4, bat4S);
        batsmans.put(bat5, bat5S);
        batsmans.put(bat6, bat6S);
        batsmans.put(bat7, bat7S);
        batsmans.put(bat8, bat8S);
        batsmans.put(bat9, bat9S);
        batsmans.put(bat10, bat10S);
    }

    private void generateBowlersRecords(){

        Player bowl1 = new Player("Jaspreet", 28, "Gujarat");
        Player bowl2 = new Player("Ashwin", 34, "Karnataka");
        Player bowl3 = new Player("Ajit", 25, "Delhi");
        Player bowl4 = new Player("Ravinder", 23, "Delhi");
        Player bowl5 = new Player("Amar", 29, "Delhi");
        Player bowl6 = new Player("Mohinder", 20, "Punjab");
        Player bowl7 = new Player("Rachin", 27, "Karnataka");
        Player bowl8 = new Player("Amar", 31, "Haryana");
        Player bowl9 = new Player("Ajit", 32, "Maharashtra");
        Player bowl10 = new Player("Rohit", 22, "UP");

        Statistics bwl1S = new Statistics(150.0, 300);
        Statistics bwl2S = new Statistics(300.0, 450);
        Statistics bwl3S = new Statistics(100.0, 100);
        Statistics bwl4S = new Statistics(80.0, 120);
        Statistics bwl5S = new Statistics(120.0, 150);
        Statistics bwl6S = new Statistics(70.0, 100);
        Statistics bwl7S = new Statistics(40.0, 150);
        Statistics bwl8S = new Statistics(180.0, 250);
        Statistics bwl9S = new Statistics(200.0, 350);
        Statistics bwl10S = new Statistics(100.0, 130);

        bowlers.put(bowl1, bwl1S);
        bowlers.put(bowl2, bwl2S);
        bowlers.put(bowl3, bwl3S);
        bowlers.put(bowl4, bwl4S);
        bowlers.put(bowl5, bwl5S);
        bowlers.put(bowl6, bwl6S);
        bowlers.put(bowl7, bwl7S);
        bowlers.put(bowl8, bwl8S);
        bowlers.put(bowl9, bwl9S);
        bowlers.put(bowl10, bwl10S);
    }

    public Map<Player, Statistics> getBatsmans() {
        return batsmans;
    }

    public Map<Player, Statistics> getBowlers() {
        return bowlers;
    }
}


/*Players Data
* Batsmen:
1) Sachin, 40 years, Maharashtra, 300 matches, 15,000 runs,
2) Virat, 35 years, Delhi, 250 matches, 12,000 runs
3) Amit, 18 years, Gujarat, 45 matches, 3,000 runs
4) Rajesh, 30 years, Gujarat, 100 matches, 5,000 runs
5) Harvinder, 33 years, Haryana, 100 matches, 5,000 runs
6) Abhi, 33 years, Delhi, 100 matches, 7,000 runs
7) Rajesh, 33 years, Gujarat, 100 matches, 5,000 runs
8) Srikanth, 23 years, Tamilnadu, 30 matches, 2,000 runs
9) Shankar, 26 years, Tamilnadu, 100 matches, 5,000 runs
10) Sudan, 22 years, Karnataka, 55 matches, 3,000 runs

*Bowlers:
1) Jaspreet, 28 years, Gujarat, 150 matches, 300 wickets
2) Ashwin, 34 years, Karnataka, 300 matches, 450 wickets
3) Ajit, 25 years, Delhi, 100 matches, 100 wickets
4) Ravinder, 23 years, Delhi, 80 matches, 120 wickets
5) Amar, 29 years, Delhi, 120 matches, 150 wickets
6) Mohinder, 20 years, Punjab, 70 matches, 100 wickets
7) Rachin, 27 years, Karnataka, 40 matches, 150 wickets
8) Amar, 31 years, Haryana, 180 matches, 250 wickets
9) Ajit, 32 years, Maharashtra, 200 matches, 350 wickets
10) Rohit, 22 years, UP, 100 matches, 130 wickets*/