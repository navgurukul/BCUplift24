package org.IndiaTeamSelection;

import java.util.Map;

public class StatisticManager{
    private Map<Players,Statistics>Batsman;

    public Map<Players, Statistics> getBatsman() {
        return Batsman;
    }

    public Map<Players, Statistics> getBowler() {
        return Bowler;
    }

    private Map<Players,Statistics>Bowler;
    public StatisticManager(){
        this.Batsman=Batsman;
        this.Bowler=Bowler;
    }

}
