package org.iccselection;

import java.util.HashSet;
import java.util.Set;

public class SelectionCommittee {

    Set<Player> selectedBatsman = new HashSet<>();
    Set<Player> selectedBowlers = new HashSet<>() ;

    SelectionCommittee(Set<Player> selectedBatsman,Set<Player> selectedBowlers ){
        this.selectedBatsman = selectedBatsman;
        this.selectedBowlers = selectedBowlers ;
    }
    public Set<Player> showSelectedBatsman(){
        return  selectedBatsman ;
    }
    public Set<Player> showSelectedBowlers(){
        return selectedBowlers ;
    }
}
