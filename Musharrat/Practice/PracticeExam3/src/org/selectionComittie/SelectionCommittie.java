package org.selectionComittie;

import org.playerRecords.Player;
import org.playerRecords.Statistics;
import org.playerRecords.StatsManager;

import java.util.*;

public class SelectionCommittie {
    private static StatsManager sm = new StatsManager();
    SortedSet<Player> selectedBatsmans = new TreeSet<>();
    SortedSet<Player> selectedBowlers = new TreeSet<>();

    public SelectionCommittie(){
        selectBatsman();
        selectBowlers();
    }

    private void selectBatsman(){

       // ArrayList<Double> maxScores = new ArrayList<Double>();
        int count = 0;
        for (Map.Entry<Player, Statistics> m: sm.getBatsmans().entrySet()){
            // for now age
            if (m.getKey().getAge() > 40){
                continue;
            }
            else if (m.getValue().getMatches() < 50){
                continue;
            }
            else{
                selectedBatsmans.add(m.getKey());
            }
        }
    }

    private void selectBowlers(){
        for (Map.Entry<Player, Statistics> m: sm.getBowlers().entrySet()){
            // for now age
            if (m.getKey().getAge() > 40){
                continue;
            }
            else if (m.getValue().getMatches() < 50){
                continue;
            }
            else{
                selectedBowlers.add(m.getKey());
            }
        }
    }

    public Set<Player> getSelectedBatsmans() {
        return selectedBatsmans;
    }

    public Set<Player> getSelectedBowlers() {
        return selectedBowlers;
    }
}
