package org.worldCupselection;

import java.util.HashSet;
import java.util.Set;

public class SelectionCommittee {
    private StatsManager statsManager;

    Set<Player> s = new HashSet<>();


    public StatsManager getStatsManager(){
        return statsManager;
    }

    SelectionCommittee(StatsManager statsManager){
        this.statsManager=statsManager;
    }

    public boolean getCeckForState(Set<Player> s){
        return true;
    }

    public String  getSelectBatsMan(Set<Player> s){
        return "Selected";
    }

    public String  getSelectBowler(Set<Player> s){
        return "Selected";
    }



}
