package org.IndianTeamSelection;

import org.IndianTeamSelection.statisties.BatsmanStatistics;
import org.IndianTeamSelection.statisties.BowlerStatistics;
import org.IndianTeamSelection.statisties.Statistics;

import java.util.HashMap;
import java.util.Map;

public class StatsManager {
    Map<Player, BatsmanStatistics> batsmanMap = new HashMap<>();
    Map<Player, BowlerStatistics>bowlerMap = new HashMap<>();


    public  StatsManager(){
        batsmanMap.put(new Player( "Sachin", 40 , "Maharashtra"),new BatsmanStatistics(15000,300));
        batsmanMap.put(new Player( "Virat", 35  , "Delhi"),new BatsmanStatistics(12000,250));
        batsmanMap.put(new Player("Amit",18, "Gujrat"),new BatsmanStatistics(3000,45));
        batsmanMap.put(new Player("Rajesh",30, "Gujrat"), new BatsmanStatistics(5000, 100));
        batsmanMap.put(new Player("Harvinder", 33, "Haryana"), new BatsmanStatistics(5000,100));
        batsmanMap.put(new Player("Abhi",33,"Dehli"), new BatsmanStatistics(7000,100));
        batsmanMap.put(new Player("Srikanth",23,"Tamilnadu"), new BatsmanStatistics(2000,30));
        batsmanMap.put(new Player("Rajesh",33, "Gujrat"), new BatsmanStatistics(5000, 100));
        batsmanMap.put(new Player("Sudan",22 ,"Karnataka"), new BatsmanStatistics(3000,55));

        bowlerMap.put(new Player("Jaspreet",28,"Gujrat"), new BowlerStatistics(300,150));
        bowlerMap.put(new Player("Ajit",25,"Karnataka"), new BowlerStatistics(100,100));
        bowlerMap.put(new Player("Ravinder",23,"Dehli"), new BowlerStatistics(80,120));
        bowlerMap.put(new Player("Amar", 29,"Dehli"), new BowlerStatistics(150,120));
        bowlerMap.put(new Player("Ashwin",34,"Karnataka"), new BowlerStatistics(450,300));
        bowlerMap.put(new Player("Mohinder",20,"Punjab"), new BowlerStatistics(100,70));
        bowlerMap.put(new Player("Rachin",27,"Karnataka"), new BowlerStatistics(150,40));
        bowlerMap.put(new Player("Ajit",32,"Maharastra"),new BowlerStatistics(350,200));
        bowlerMap.put(new Player("Rohit",22,"UP"), new BowlerStatistics(130,100));
        bowlerMap.put(new Player("Amar",31,"Haryana"), new BowlerStatistics(250,180));
    }
    public Map<Player, BatsmanStatistics> getBatsmanMap(){
        return  batsmanMap;
    }
    public Map<Player, BowlerStatistics> getBowlerMap(){

        return  bowlerMap;
    }
}
