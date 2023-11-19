package precticeexam3;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.*;

public class SelectionCommittee {
    private HashMap<Player,Statistics> batsmenMap = new HashMap<>();
    private HashMap<Player,Statistics> bowlerMap = new HashMap<>();

    public SelectionCommittee(HashMap<Player, Statistics> batsmenMap,HashMap<Player,Statistics> bowlerMap) {
        this.batsmenMap = batsmenMap;
        this.bowlerMap = bowlerMap;
    }

    SortedSet<Player> selectedBatsMens = new TreeSet<>();
    SortedSet<Player> selectedBowlers = new TreeSet<>();




    public  SortedSet<Player>  getSelectedBatters(){
        while(true){
            for(Map.Entry<Player,Statistics> i : batsmenMap.entrySet()){

                Player key = i.getKey();
                Statistics value = i.getValue();
                if(key.getAge()>=18 && key.getAge()<=35 && value.getNumberOfMatches()>=50){
                    selectedBatsMens.add(key);
                }

//                System.out.println(i);
            }
            if(selectedBatsMens.size()==3){
                break;
            }
        }
        return selectedBatsMens;
    }

    public SortedSet<Player> getSelectedBowler(){
        while(true){
            for(Map.Entry<Player,Statistics> i : bowlerMap.entrySet()){
                Player key = i.getKey();
                Statistics value = i.getValue();
                if(key.getAge()>=18 && key.getAge()<=35 && value.getNumberOfMatches()>=50){
                    selectedBowlers.add(key);
                }

            }
            if(selectedBowlers.size()==2){
                break;
            }
        }
        return selectedBowlers;
    }


}
