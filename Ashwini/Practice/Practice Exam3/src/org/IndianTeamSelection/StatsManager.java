package org.IndianTeamSelection;

import org.IndianTeamSelection.statisties.Statistics;

import java.util.HashMap;
import java.util.Map;

public class StatsManager {
    Map<Player, Statistics> batsmanMap = new HashMap<>();
    Map<Player, Statistics>boolerMap = new HashMap<>();

    StatsManager(){
        batsmanMap.put(new Player( "Sachin", 40 , "Maharashtra"),new Statistics(15000,300));
        batsmanMap.put(new Player( "Virat", 35  , "Delhi"),new Statistics(12000,250));
        batsmanMap.put(new Player("Amit",18, "Gujrat"),new Statistics(3000,45));
        batsmanMap.put(new Player("Rajesh",30, "Gujrat"), new Statistics(5000, 100));
        batsmanMap.put(new Player("Harvinder", 33, "Haryana"), new Statistics(5000,100));
        batsmanMap.put(new Player("Abhi",33,"Dehli"), new Statistics(7000,100));
        batsmanMap.put(new Player("Srikanth",23,"Tamilnadu"), new Statistics(2000,30));
        batsmanMap.put(new Player("Rajesh",33, "Gujrat"), new Statistics(5000, 100));
        batsmanMap.put(new Player("Sudan",22 ,"Karnataka"), new Statistics(3000,55));

        boolerMap.put(new Player("Jaspreet",28,"Gujrat"), new Statistics(300,150));
        boolerMap.put(new Player("Ashwin",34,"Karnataka"), new Statistics(450,300));
        boolerMap.put(new Player("Ajit",25,"Karnataka"), new Statistics(100,100));
        boolerMap.put(new Player("Ravinder",23,"Dehli"), new Statistics(80,120));
        boolerMap.put(new Player("Amar", 29,"Dehli"), new Statistics(150,120));
        boolerMap.put(new Player("Mohinder",20,"Punjab"), new Statistics(100,70));
        boolerMap.put(new Player("Rachin",27,"Karnataka"), new Statistics(150,40));


    }
    public Map<Player, Statistics> getBatsmanMap(){
        return  batsmanMap;
    }
    public Map<Player, Statistics> getBoolerMap(){
        return  boolerMap;
    }
}
