package org.uplift.indianTeamSelection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class SelectionCommity {
    Set<Player> selectBatsMan=new TreeSet<>();
    Set<Player> selectBollers=new TreeSet<>();
    boolean isEligiblebollers;
    boolean isEligiblebatters;
    Double avgBatter;
    Double avgBollers;

    public boolean isEligiblebatters() {
        return isEligiblebatters;
    }

    public boolean isEligiblebollers() {
        return isEligiblebollers;
    }

    public Double getAvgBatter() {
        return avgBatter;
    }

    public Double getAvgBollers() {
        return avgBollers;
    }

    private String getKey(Map<String, Integer> map, Integer value){
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if (Objects.equals(value, entry.getValue())){
                return entry.getKey();
            }
        }
        return " ";
    }
    public boolean isEligiblebollers(Map<Player,Statistic> bollers){
        for(Map.Entry<Player, Statistic> entry:bollers.entrySet()) {
            if ((entry.getKey().getAge() > 35)) {
                isEligiblebollers=true;
            }
            isEligiblebollers=false;
        }
        return isEligiblebollers;

    }
    public boolean isEligiblebatters(Map<Player,Statistic> batters){
        for(Map.Entry<Player, Statistic> entry:batters.entrySet()) {
            if ((entry.getKey().getAge() > 35)) {
                isEligiblebatters=true;
            }
            isEligiblebatters= false;
        }
        return isEligiblebatters;
    }
    public Double calculateAvgOfBatters(Map<Player,Statistic> batters){
        for(Map.Entry<Player,Statistic> entry:batters.entrySet()){
            Double avgBatter= (double) (entry.getValue().getMatches()/entry.getValue().getNumber());
            return avgBatter;
        }
        return avgBatter;
    }
    public Double calculateAvgOfBollers(Map<Player,Statistic> bollers){
        for(Map.Entry<Player,Statistic> entry:bollers.entrySet()){
            Double avgBollers= (double) (entry.getValue().getMatches()/entry.getValue().getNumber());
            return avgBollers;
        }
        return avgBollers;
    }



}
