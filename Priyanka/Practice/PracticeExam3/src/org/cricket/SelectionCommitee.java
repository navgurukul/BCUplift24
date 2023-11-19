package org.cricket;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SelectionCommitee {
    Set<Player>sortedBatsman = new TreeSet<>();
    Set<Player>sortedBowler = new TreeSet<>();
    Set<String>state1 = new TreeSet<>();
    Set<String>state2 =new TreeSet<>();



    public void calculateBatsmanPerformance(Map<Player,Statistic> listOfPlayer,int age,String state) {
        if ((age<35) && (!state1.contains(state)) {
            state1.add(state);
            sortedBatsman.add();
        }
    }
    public void calculateBowlerPerformance(Map<Player,Statistic> listOfPlayer,int age,String state) {
        if ((age<35) && (!state2.contains(state))) {
            state2.add(state);
            sortedBowler.add();
        }

    }
}
