package CricketSelectionManager;

import java.util.HashMap;
import java.util.Map;

public class StatsManager{
    Map<Player, Statistics> batters = new HashMap<>();
    Map<Player, Statistics> bowlers = new HashMap<>();

    public StatsManager() {
        checkEligibleBatters(batter1 , s1);
        checkEligibleBatters(batter2 , s2);
        checkEligibleBatters(batter3 , s3);
        checkEligibleBatters(batter4 , s4);
        checkEligibleBatters(batter5 , s5);
        checkEligibleBatters(batter6 , s6);
        checkEligibleBatters(batter7 , s7);
        checkEligibleBatters(batter8 , s8);
        checkEligibleBatters(batter9 , s9);
        checkEligibleBatters(batter10 , s10);
        checkEligiblebowlers(bowler1, s11);
        checkEligiblebowlers(bowler2, s12);
        checkEligiblebowlers(bowler3, s13);
        checkEligiblebowlers(bowler4, s14);
        checkEligiblebowlers(bowler5, s15);
        checkEligiblebowlers(bowler6, s16);
        checkEligiblebowlers(bowler7, s17);
        checkEligiblebowlers(bowler8, s18);
        checkEligiblebowlers(bowler9, s19);
        checkEligiblebowlers(bowler10, s20);

        this.batters = batters;
        this.bowlers = bowlers;
    }
    public void checkEligiblebowlers(Player p, Statistics s){
        if (p.getAge()<=35 && s.getMatches()>=50){
            bowlers.put(p,s);
        }
    }
    public void checkEligibleBatters(Player p, Statistics s){
        if (p.getAge()<=35 && s.getMatches()>=50){
            batters.put(p,s);
        }
    }

    public Map<Player, Statistics> getBatters() {
        return batters;
    }
    public Map<Player, Statistics> getBowlers() {
        return bowlers;
    }

    Player batter1 = new Player("Sachin",40, "Maharashtra");
    Statistics s1 = new Statistics(300,15000);
    Player batter2 = new Player("Virat", 35, "Delhi");
    Statistics s2 = new Statistics(250, 12000);
    Player batter3 = new Player("Amit", 18, "Gujarat");
    Statistics s3 = new Statistics(45, 3000);
    Player batter4 = new Player("Rajesh", 30, "Gujarat");
    Statistics s4 = new Statistics(100, 5000);
    Player batter5 = new Player(" Harvinder",33, "Haryana");
    Statistics s5 = new Statistics(100, 5000);
    Player batter6 = new Player("Abhi",33, "Delhi");
    Statistics s6 = new Statistics(100, 7000);
    Player batter7 = new Player("Rajesh",33, "Gujarat");
    Statistics s7 = new Statistics(100, 5000);
    Player batter8 = new Player("Srikanth",23, "Tamilnadu");
    Statistics s8 = new Statistics(30, 2000);
    Player batter9 = new Player("Shankar", 26, "Tamilnadu");
    Statistics s9 = new Statistics(100,5000);
    Player batter10 = new Player("Sudan", 22, "Karnataka");
    Statistics s10 = new Statistics(55, 3000);
    Player bowler1 = new Player("Jaspreet",28 ,"Gujarat");
    Statistics s11 = new Statistics(150, 300);
    Player bowler2 = new Player("Ashwin", 34, "Karnataka");
    Statistics s12 = new Statistics(200, 450);
    Player bowler3 = new Player("Ajit", 34, "Karnataka");
    Statistics s13 = new Statistics(100,100);
    Player bowler4 = new Player("Ravinder", 23, "Delhi");
    Statistics s14 = new Statistics(80,120);
    Player bowler5 = new Player("Amar",29 , "Delhi");
    Statistics s15 = new Statistics(120,150);
    Player bowler6 = new Player("Mohinder", 20, "Punjab");
    Statistics s16 = new Statistics(70,100);
    Player bowler7 = new Player("Rachin",27, "Karnataka");
    Statistics s17 = new Statistics(40, 150);
    Player bowler8 = new Player("Amar", 31, "Haryana");
    Statistics s18 = new Statistics(180,250);
    Player bowler9 = new Player("Ajit", 32, "Maharashtra");
    Statistics s19 = new Statistics(200,350);
    Player bowler10 = new Player( "Rohit", 22, "UP");
    Statistics s20 = new Statistics(100,130);

    public String toString(){
        return batters.toString() + bowlers.toString();
    }

}
