/*
Input n Batsman of n bowler data.
Every player will have details like name, age, state.
every batsman and bowler will have statistics such as number of matches & runs/wickets depending on batter/bowler.
Select 3 batsman and 2 bowler from list depending on their performance, age, state.
No more than 1 player can be selected from a state. Performance will be decided based on average considering number
of matches (will not take players who has played less than 50 matches) Age can't be more than 35n.
but a player needs to have played minimum of 50 matches.
Display selection of batsman & bowler by performance & name.
*/


import org.players.Players;
import org.statistics.CricketSelectionComittee;

import java.util.Map;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        CricketSelectionComittee csc = new CricketSelectionComittee();
        System.out.println("Batsmen are: ");
        csc.setBatsmen();
        System.out.println("Bowler are : ");
        csc.setBowler();


    }
}