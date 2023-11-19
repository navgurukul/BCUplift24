package org;

import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SelectionCommunity {

    /*pubic boolean isEligible (Map<Player, Statistic> batsmanMap){
        for (Map.Entry<Player,Statistic> i:batsmanMap.entrySet()){
            if (i.getKey().getAge() < 35 && i.getValue().getNumOfMatches()>50)
                return true;
        }
    }*/
    Set<Player> batsmanSet =  new TreeSet<>();
    Set<Player>  SelectBatsman(Map<Player, Statistic> batsmanMap){
        for (Map.Entry<Player,Statistic> i:batsmanMap.entrySet()){
            if (i.getKey().getAge() < 35 && i.getValue().getNumOfMatches()>50)
                batsmanSet.add((Player) i);

        }
        return batsmanSet;
    }

    Set<Player> bowlerSet = new TreeSet<>();
    Set<Player>  SelectBatsman(Map<Player, Statistic> bowlerMap){
        for (Map.Entry<Player,Statistic> i:bowlerMap.entrySet()){
            if (i.getKey().getAge() < 35 && i.getValue().getNumOfMatches()>50)
                bowlerSet.add((Player) i);

        }
        return bowlerSet;
    }

    SortedSet<Player> batsmanPerformanceSet = new SortedSet<Player>();

    SortedSet<Player> CalculateBatsmanPerformance(Statistic s){
       double ans=  s.CalulateAverage();
       batsmanPerformanceSet.add(s);

    }

    SortedSet<Player> bowlerPerformanceSet = new SortedSet<Player>();

    SortedSet<Player> CalculateBowlerPerformance(Statistic s){
        double ans=  s.CalulateAverage();
        bowlerPerformanceSetPerformanceSet.add(s);

    }
}
