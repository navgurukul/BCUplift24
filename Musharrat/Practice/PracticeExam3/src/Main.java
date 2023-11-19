/*
Indian Team Selection
* Input n batsman &  n bowler data
* Every player will have details like name, age, state
* Every batsman & bowler will have statistics such as number of matches & runs/wickets
    depending on batter/bowler.
* Select 3 batsman and 2 bowler from list depending on their performance, age, state;
* No 1 player per state. Performance will be decided based on average, but a
    player needs to have played minimum of 50 matches.
* Display selection of batsman & bowlers by performance & name;
*/

import org.playerRecords.Player;
import org.selectionComittie.SelectionCommittie;

public class Main {
    public static void main(String[] args) {
        SelectionCommittie sc = new SelectionCommittie();

        System.out.println("Batsman: ");
        System.out.println("Size: "+ sc.getSelectedBatsmans().size());
        
        for (Player p: sc.getSelectedBatsmans()){
            System.out.println(p);
        }

        System.out.println("Bowlers: ");
        System.out.println("Size: "+ sc.getSelectedBowlers().size());
        for (Player p1: sc.getSelectedBowlers()){
            System.out.println(p1);
        }

    }
}
