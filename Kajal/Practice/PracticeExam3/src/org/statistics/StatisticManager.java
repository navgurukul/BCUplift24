package org.statistics;

import org.players.Players;

import java.util.HashMap;
import java.util.Map;

public class StatisticManager {
    private Map<Players, int[]> batsMen = new HashMap<>();
    private Map<Players, int[]> bowlers = new HashMap<>();
    public StatisticManager() {
        Players batsmen1 = new Players("Sachin", 40, "Maharashtra");
        Players batsmen2 = new Players("Virat", 35, "Delhi");
        Players batsmen3 = new Players("Amit", 18, "Gujarat");
        Players batsmen4 = new Players("Rajesh", 30, "Gujarat");
        Players batsmen5 = new Players("Harvinder", 33, "Haryana");
        Players batsmen6 = new Players("Abhi", 33, "Delhi");
        Players batsmen7 = new Players("Rajesh", 33, "Gujarat");
        Players batsmen8 = new Players("Srikanth", 23, "Tamilnadu" );
        Players batsmen9 = new Players("Shankar", 26, "Tamilnadu" );
        Players batsmen10 = new Players("Sudan", 22, "Karnataka");
        int[] run1 = {300, 1500};
        int[] run2 = {250, 12000};
        int[] run3 = {45, 3000};
        int[] run4 = {100, 5000};
        int[] run5 = {100, 5000};
        int[] run6 = {100, 7000};
        int[] run7 = {100, 5000};
        int[] run8 = {30, 2000};
        int[] run9 = {100, 5000};
        int[] run10 = {55, 3000};


        batsMen.put(batsmen1,run1 );
        batsMen.put(batsmen2, run2);
        batsMen.put(batsmen3, run3);
        batsMen.put(batsmen4, run4);
        batsMen.put(batsmen5, run5);
        batsMen.put(batsmen6, run6);
        batsMen.put(batsmen7, run7);
        batsMen.put(batsmen8, run8);
        batsMen.put(batsmen9, run9);
        batsMen.put(batsmen10, run10);

        Players bowler1 = new Players("Jaspreet", 28, "Gujarat");
        Players bowler2 = new Players("Ashwin", 34, "Karnataka");
        Players bowler3 = new Players("Ajit", 25 , "Delhi");
        Players bowler4 = new Players("Ravinder", 23 , "Delhi");
        Players bowler5 = new Players("Amar", 29 , "Delhi");
        Players bowler6 = new Players( "Mohinder", 20 , "Punjab");
        Players bowler7 = new Players("Rachin", 27 , "Karnataka");
        Players bowler8 = new Players("Amar", 31 , "Haryana");
        Players bowler9 = new Players("Ajit", 32 , "Maharashtra");
        Players bowler10 = new Players("Rohit", 22 , "UP");
        int[] wick1 = {150, 300};
        int[] wick2 = {300 , 450};
        int[] wick3 = { 100 , 100};
        int[] wick4 = { 80 , 120};
        int[] wick5 = {120 , 150};
        int[] wick6 = {70 , 100};
        int[] wick7 = {40,150};
        int[] wick8 = {180,250};
        int[] wick9 = {200, 350};
        int[] wick10 = {100, 130};
        bowlers.put(bowler1, wick1);
        bowlers.put(bowler2, wick2);
        bowlers.put(bowler3, wick3);
        bowlers.put(bowler4, wick4);
        bowlers.put(bowler5, wick5);
        bowlers.put(bowler6, wick6);
        bowlers.put(bowler7, wick7);
        bowlers.put(bowler8, wick8);
        bowlers.put(bowler9, wick9);
        bowlers.put(bowler10, wick10);
    }

    public Map<Players, int[]> getBatsMen() {
        return batsMen;
    }

    public Map<Players, int[]> getBowlers() {
        return bowlers;
    }
}
