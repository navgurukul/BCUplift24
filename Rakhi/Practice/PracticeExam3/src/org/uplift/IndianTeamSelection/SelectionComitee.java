package org.uplift.IndianTeamSelection;

import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SelectionComitee {
    Set<Player> batsmanSet=new TreeSet<>();
    Set<Player> bowlerSet=new TreeSet<>();
    public void calculateBatsmanPerformance(StatisticsManager s){
        for(Map.Entry<Player,Statistics>m:s.getBatsman().entrySet()){
            if(m.getValue().getNumberOfMatches()>=50){
                batsmanSet.add(m.getKey());
            }
        }
    }

    public void calculateBowlerPerformance(StatisticsManager s){
        for(Map.Entry<Player,Statistics> m: s.getBowler().entrySet()){
            if(m.getValue().getNumberOfMatches()>=50){
                bowlerSet.add(m.getKey());
            }
        }
    }
    public void selectBatsman(Set<Player> bowlerSet){
    }

    public void selectBowler(){

    }
}
