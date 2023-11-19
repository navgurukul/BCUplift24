package org;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SelectionCommittiee {
    SortedSet<Double> selectBatsMan=new TreeSet<>();
    SortedSet<Double> selectBowler= new TreeSet<>();
    void calculateBatManPerformance(Statistics s){
        selectBatsMan.add(s.calculateAvg());
    }
      void calculateBowlerPerformance(Statistics s){
        selectBowler.add(s.calculateAvg());
    }

    boolean isEligible(Player player,Statistics s){
        if(player.getAge()>18 && player.getAge()<=35 && s.getMatches()>=50){
            return true;
        }
        else{
            return false;
        }
    }
}
