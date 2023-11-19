package org.uplift.IndianTeamSelection;

import java.util.HashMap;
import java.util.Map;


public class StatisticsManager {
    Map<Player,Statistics> batsman=new HashMap<>();
    Map<Player,Statistics> bowler=new HashMap<>();

    /*StatisticsManager(Map<Player,Statistics> batsman,Map<Player,Statistics> bowler){
        this.batsman=batsman;
        this.bowler=bowler;
    }*/


    public void createBatsman(Player p,Statistics s){
        batsman.put(p,s);
    }

    public void createBowler(Player p,Statistics s){
        bowler.put(p,s);
    }


    public Map<Player,Statistics> getBatsman(){
        return batsman;
    }

    public Map<Player,Statistics> getBowler(){
        return bowler;
    }
}
