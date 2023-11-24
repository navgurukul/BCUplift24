package exam.org;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SelectionCommittee {
    Set<Player> play=new LinkedHashSet<>();
    List<String> l1=new ArrayList<>();

    List<String> l2=new ArrayList<>();

    public void addPlayers(Set<Player> p1){
        int i=0;
        int j=0;
        for(Player c1: p1){
            if(c1.getAge()<=35 && c1.getStatics().getNumberOfMatches()>50 && i<3 && !l1.contains(c1.getState())){
                l1.add(c1.getState());
                play.add(c1);
                i++;
            }
            if(c1.getAge()<=35 && c1.getStatics().getNumberOfMatches()>50 && j<2 && c1.getPlayerRole().equals("Bowler") && !l2.contains(c1.getState())){
                l2.add(c1.getState());
                play.add(c1);
                j++;
            }
        }
    }


//    Set<Player> bow=new LinkedHashSet<>();
//    List<String> l2=new ArrayList<>();
//    public void addBowler(Set<Player> bowler1){
//        int i=0;
//        for(Player c1:bowler1){
//            if(c1.getAge()<=35 && c1.getStatics().getNumberOfMatches()>50 && i<2 && !l1.contains(c1.getState())){
//                l2.add(c1.getState());
//                bow.add(c1);
//                i++;
//            }
//        }
//    }

    public Set<Player> getPlay(){
        return play;
    }

//    public Set<Player> getBow(){
//        return bow;
//    }


}
