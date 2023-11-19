package india.team.selection.programm;

import java.util.HashMap;

public class StatsManages {
    HashMap<Player,Statistics>batsman=new HashMap<>();
    HashMap<Player,Statistics>bowler=new HashMap<>();

    public HashMap<Player, Statistics> getBatsman() {
        return batsman;
    }

    public HashMap<Player, Statistics> getBowler() {
        return bowler;
    }
}
