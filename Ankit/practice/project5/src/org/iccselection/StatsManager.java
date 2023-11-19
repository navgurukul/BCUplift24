package org.iccselection;

import java.util.HashMap;
import java.util.Map;

public class StatsManager {
    private Map<Player,Statistics> batsman = new HashMap<>();
    private Map<Player,Statistics> bowler = new HashMap<>();

    StatsManager(Map<Player,Statistics> batsman ,Map<Player,Statistics> bowler ){
        this.batsman = batsman ;
        this.bowler = bowler ;
    }
    public Map<Player,Statistics> getBatsman(){
        return batsman ;
    }
    public Map<Player,Statistics> getBowler(){
        return bowler ;
    }
    public boolean checkStatesForBatsman(Player obj){
        boolean flag = false;
        for(Map.Entry<Player,Statistics> i : batsman.entrySet()){
            if(!i.getKey().getState().equals(obj.getState())){
                flag = true ;
            }

        }
        return flag ;
    }
    public boolean checkStatesForBowlers(Player obj){
        boolean flag1 = false;
        for(Map.Entry<Player,Statistics> i : bowler.entrySet())
            if (!i.getKey().getState().equals(obj.getState())) {
                flag1 = true;
            }
        return flag1 ;
    }
}
