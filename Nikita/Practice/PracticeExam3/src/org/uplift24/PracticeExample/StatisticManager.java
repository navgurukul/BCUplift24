package org.uplift24.PracticeExample;

import java.util.HashMap;
import java.util.Map;

public class StatisticManager {
    private HashMap<Player,Statistics> batsmen;
    private HashMap<String, Integer> bowlers;

    public StatisticManager(HashMap<Player,Statistics> batsmen,HashMap<String, Integer> bowlers){
        this.batsmen=batsmen;
        this.bowlers=bowlers;
    }

    public HashMap<Player, Statistics> getBatsmen() {
        return batsmen;
    }

    public HashMap<String, Integer> getBowlers() {
        return bowlers;
    }
}
