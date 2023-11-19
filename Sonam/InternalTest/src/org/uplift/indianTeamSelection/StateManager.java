package org.uplift.indianTeamSelection;


import java.util.HashMap;
import java.util.Map;

public class StateManager {
    Map<Player,Statistic> bollers=new HashMap<>();
    Map<Player,Statistic> batters=new HashMap<>();
    public void addBollers(Player p, Statistic s){
        bollers.put(p,s);
    }
    public void addBatters(Player p, Statistic s){
        batters.put(p,s);
    }
    public Map<Player,Statistic> getBollers(){
        return bollers;
    }

    public Map<Player, Statistic> getBatters() {
        return batters;
    }

}
