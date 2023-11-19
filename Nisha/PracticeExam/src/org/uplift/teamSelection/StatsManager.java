package org.uplift.teamSelection;

import java.util.HashMap;
import java.util.Map;

public class StatsManager {
    static Map<Players,Statistics> batsmen = new HashMap<>();
    Map<Players,Statistics> bowler = new HashMap<>();

    static Map<Players,Statistics> getBatsmen() {
        Players p1 = new Players("Sachin", 40, "Maharastra");
        Players p2 = new Players("Virat", 35, "Delhi");
        Players p3 = new Players("Amit", 18, "Gujarat");
        Players p4 = new Players("Rajesh", 30, "Gujarat");
        Players p5 = new Players("Harvinder", 33, "Haryana");
        Players p6 = new Players("Abhi", 33, "Delhi");
        Players p7 = new Players("Rajesh", 33, "Gujarat");
        Players p8 = new Players("Srikahnth", 23, "TamilNadu");
        Players p9 = new Players("Ajit", 26, "TamilNadu");
        Players p10 = new Players("Rohit", 22, "Karnataka");

        Statistics p1r1 = new Statistics(15000, 300);
        Statistics p2r2 = new Statistics(12000, 250);
        Statistics p3r3 = new Statistics(3000, 45);
        Statistics p4r4 = new Statistics(5000, 100);

        Statistics p5r5 = new Statistics(7000, 100);
        Statistics p6r6 = new Statistics(5000, 100);
        Statistics p7r7 = new Statistics(2000, 30);
        Statistics p8r8 = new Statistics(300, 1500);
        Statistics p9r9 = new Statistics(5000, 100);
        Statistics p10r10 = new Statistics(3000, 55);

        batsmen.put(p1, p1r1);
        batsmen.put(p2, p2r2);
        batsmen.put(p3, p3r3);
        batsmen.put(p4, p4r4);
        batsmen.put(p5, p5r5);
        batsmen.put(p6, p6r6);
        batsmen.put(p7, p7r7);
        batsmen.put(p8, p8r8);
        batsmen.put(p9, p9r9);
        batsmen.put(p10, p10r10);
        return batsmen;
    }

    Map<Players,Statistics> getBowler() {
        Players p1 = new Players("Jaspreet", 28, "Gujarat");
        Players p2 = new Players("Ashwin", 34, "Karnataka");
        Players p3 = new Players("Ajit", 25, "Delhi");
        Players p4 = new Players("Ravindar", 23, "Delhi");
        Players p5 = new Players("Amar", 29, "Delhi");
        Players p6 = new Players("Mohinder", 20, "Punjab");
        Players p7 = new Players("Rajesh", 27, "Karnataka");
        Players p8 = new Players("Srikahnth", 31, "Haryana");
        Players p9 = new Players("Virat", 32, "Maharashtra");
        Players p10 = new Players("Virat", 22, "UP");

        Statistics p1r1 = new Statistics(300, 150);
        Statistics p2r2 = new Statistics(450, 300);
        Statistics p3r3 = new Statistics(100, 100);
        Statistics p4r4 = new Statistics(120, 80);

        Statistics p5r5 = new Statistics(150, 120);
        Statistics p6r6 = new Statistics(100, 70);
        Statistics p7r7 = new Statistics(40, 150);
        Statistics p8r8 = new Statistics(250, 180);
        Statistics p9r9 = new Statistics(350, 200);
        Statistics p10r10 = new Statistics(130, 100);

        bowler.put(p1, p1r1);
        bowler.put(p2, p2r2);
        bowler.put(p3, p3r3);
        bowler.put(p4, p4r4);
        bowler.put(p5, p5r5);
        bowler.put(p6, p6r6);
        bowler.put(p7, p7r7);
        bowler.put(p8, p8r8);
        bowler.put(p9, p9r9);
        bowler.put(p10, p10r10);
        return bowler;
    }


}
