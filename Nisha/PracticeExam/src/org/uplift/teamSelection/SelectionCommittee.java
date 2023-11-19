package org.uplift.teamSelection;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SelectionCommittee {
    Set<Players> selectBatsmen = new HashSet<>();
    Set<Players> SelectionBowler = new HashSet<>();
    SortedSet<Statistics> ageMatchEligible = new TreeSet<>();


    Set<Statistics> calculateBatsmenPerformance() {
        for (Statistics i : (StatsManager.getBatsmen()).values()) {
            boolean b = (Players.getAge()) < 35;
            if (i.getNoOfMatches() > 50 && b) {
                ageMatchEligible.add(i);
            }
        }
        return ageMatchEligible;
    }
}
