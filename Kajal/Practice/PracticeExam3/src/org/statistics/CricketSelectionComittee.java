package org.statistics;

import org.players.Players;

import java.util.*;

public class CricketSelectionComittee{
    Map<Players, int[]> batsmen = new HashMap<>();
    Map<Players, int[]> bowler = new HashMap<>();

    public CricketSelectionComittee(){
        StatisticManager sm = new StatisticManager();
        batsmen = sm.getBatsMen();
        bowler = sm.getBowlers();
    }

    public Map<Players, Double> setBatsmenavg() {
        Statistics s = new Statistics();
        Map<Players, Double> setavg = new HashMap<Players, Double>();
        for (Players p1 : batsmen.keySet()){
            if (isEligible(p1)){
                setavg.put(p1, s.calculateAverage(batsmen.get(p1)[0], batsmen.get(p1)[1]));
            }
        }
        return setavg;
    }

    public Map<Players, Double> setBowleravg() {
        Statistics s = new Statistics();
        Map<Players, Double> setaverage = new HashMap<Players, Double>();
        for (Players p1 : bowler.keySet()){
            if (isEligible(p1)){
                setaverage.put(p1, s.calculateAverage(bowler.get(p1)[0], bowler.get(p1)[1]));
            }
        }
        return setaverage;
    }

    public void setBatsmen(){
        Map<Players, Double> batsmens = new HashMap<>();
        batsmens = setBatsmenavg();
        int c=0;
        for (Map.Entry<Players, Double> m: batsmens.entrySet()){
            if (c==3){break;};
            System.out.println(m.getKey()+", Average "+ m.getValue());
            c++;
        }

    }

    public void setBowler(){
        Map<Players, Double> bowlers = new HashMap<>();
        bowlers = setBowleravg();
        int c=0;
        for (Map.Entry<Players, Double> m: bowlers.entrySet()){
            if (c==2){break;};
            System.out.println(m.getKey()+", Average "+ m.getValue());
            c++;
        }
    }

    public boolean isEligible(Players p){
        return p.getAge()<=35;
    }

}
