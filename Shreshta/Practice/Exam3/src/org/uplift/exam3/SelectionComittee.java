package org.uplift.exam3;

import java.util.HashSet;
import java.util.Set;

public class SelectionComittee {
    private Set<Player> setestBatter = new HashSet<>();
    private Set<Player> setestBowler = new HashSet<>();

    public SelectionComittee(Set<Player> setestBatter, Set<Player> setestBowler) {
        this.setestBatter = setestBatter;
        this.setestBowler = setestBowler;
    }

    public Set<Player> getSetestBatter() {
        return setestBatter;
    }

    public Set<Player> getSetestBowler() {
        return setestBowler;
    }

    public Set calculateBatPerf(){
        return setestBatter;
    }
}
