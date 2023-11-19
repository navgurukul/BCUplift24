package org.uplift.teamSelection;

import java.util.HashMap;
import java.util.Map;

public class StatsManager   {
    Map<Players,Statistics> batsMen= new HashMap<>();
    Map<Players,Statistics> bowlers= new HashMap<>();

//    public void getBatsMen(Players pl){
//        batsMen.put
//    }

    public StatsManager(Map<Players, Statistics> batsMen,Map<Players,Statistics>bowlers) {
        this.batsMen = batsMen;
        this.bowlers=bowlers;
    }


    public boolean isEligible(){
        return true;
    }

}


