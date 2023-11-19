package org.criketSelection;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StatsManager {
    private Map<Players,Statistic> batsman ;
    private Map<Players,Statistic> bowlwer;
    private Statistic getNoOfMatches;

    StatsManager(Map<Players,Statistic> batsman,Map<Players,Statistic> bowler,Statistic getNoOfMatches){
        this.batsman=batsman;
        this.bowlwer=bowlwer;
        this.getNoOfMatches=getNoOfMatches;

    }
    Set<Players> shortlistedBatsman = new HashSet<>();
    Set<Players> shortlistedBowlwer = new HashSet<>();
    public boolean iseligible() {
        for (Players a : batsman.values()) {
            if (a.getAge() > 35) &&(getNoOfMatches() > 50) {
                shortlistedBatsman.add(a);
            }
        }
        for (Players b : bowlwer.values()) {
            if (b.getAge() > 35) &&(getNoOfMatches() > 50) {
                shortlistedBowlwer.add(b);
            }
        }
        return true;
    }
    SortedSet<shortlistedBatsman> finalList = new TreeSet<>();



}
