package org.uplift.PracticeExam3.Cricket;

import org.uplift.PracticeExam3.Players;

import java.util.SortedSet;
import java.util.TreeSet;

public class SelectionCommittee {
    SortedSet<Players> batsmanDetails = new TreeSet<>();
    SortedSet<Double> bowlerDetails = new TreeSet<>();
    /*public void selectBatman(Players p, StackManager s){
    }
    public void selectBowler(Players p,StackManager s){


    }*/

    boolean calculateBatmanPerformance(Players p, Statistics s) {
        double avg  = s.calculateAverage();
        //bat.add(avg);



    void isEligible(Players p,Statistics s){
        if (p.getAge() < 35 ) {
            if (s.getNoOfMatches() > 50) {
                return true;
                batsmanDetails.add(p);
            }
        }
        return false;
    }



}
