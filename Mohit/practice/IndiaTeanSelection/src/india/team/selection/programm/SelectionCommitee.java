package india.team.selection.programm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SelectionCommitee{
    Set<Player>selectBatsman=new HashSet<>();
    Set<Player>selectBowler=new HashSet<>();

    public Set<Player> getSelectBatsman() {
        return selectBatsman;
    }

    public Set<Player> getSelectBowler() {
        return selectBowler;
    }

    ArrayList<Player> storeplayer=new ArrayList<>();
    //TreeSet<Player> PlayerManagement= new TreeSet<>();

    public void addPlayer(Player py){
        if(py.getAge()<=35) {
            storeplayer.add(py);
        }
    }

    public ArrayList<Player> getStoreplayer() {
        return storeplayer;
    }
}
