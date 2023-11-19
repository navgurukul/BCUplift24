package org.IndianTeamSelection;

import org.IndianTeamSelection.statisties.Statistics;

import java.util.Map;
import java.util.TreeSet;

public class Selectioncommity {
    StatsManager statsdata = new StatsManager();



    public TreeSet<Map.Entry<Player, Statistics>> isEligiable(Map<Player, Statistics> map) {
        TreeSet<Map.Entry<Player, Statistics>> primeCustomers = new TreeSet<>();
        for (Map.Entry<Player, Statistics> entry : map.entrySet()) {
            if ((entry.getKey().getAge() <= 35) && (entry.getValue().getMatches() > 50)) {
                primeCustomers.add(entry);
            }
        }
        return primeCustomers;
    }

    public void  calculateperformance(){

    }
}


