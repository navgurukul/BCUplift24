package org.uplift.teamSelection;

import java.util.HashSet;
import java.util.Set;

public class SelectionCommittee{


    public Set<Players> selectBatsmen=  new HashSet<>();
    Set<Players> selectBowlers= new HashSet<>();

    public void calcBatsmanPerformance(Players addPlayer){
        selectBatsmen.add(addPlayer);
        
    }
    public void calcBowlerPerformance(Players addPlayer){
        selectBatsmen.add(addPlayer);

    }



    public void selectBatsmen(Players p1) {
    }
}
