package org.uplift24.PracticeExample;

import java.util.Set;
import java.util.*;

public class SelectionCommittee {
    private StatisticManager sm;
    public SelectionCommittee(StatisticManager sm){
        this.sm=sm;
    }

    public StatisticManager getSm() {
        return sm;
    }
    Set<Player> BatsMen=new TreeSet<>();
    public boolean isEligibleBatsmen(Player p,Statistics s){
        if((p.getAge()<=35)&&(s.getMatches()>=50)&&) {
            BatsMen.add(sm.getBatsmen());
        }
    }

    Set<Player> Bowlers=new TreeSet<>();
    public boolean isEligibleBowlers(Player p,Statistics s){
        if((p.getAge()<=35)&&(s.getMatches()>=50)) {
            Bowlers.add(sm.getBowlers()));
        }
    }
}
