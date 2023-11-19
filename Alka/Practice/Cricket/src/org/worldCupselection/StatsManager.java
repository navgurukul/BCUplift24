package org.worldCupselection;
import java.util.HashMap;
import java.util.Map;


public class StatsManager {

//    StatsManager s =  new StatsManager();
    Map<Player, Statistics> batters = new HashMap<>();
    Map<Player, Statistics> bowlers = new HashMap<>();

    public StatsManager(Map<Player, Statistics> batters, Map<Player, Statistics> bowlers){
        /*isEligibleBatter(batter1,n1);
        isEligibleBatter(batter2,n2);
        isEligibleBatter(batter3,n3);
        isEligibleBatter(batter4,n4);
        isEligibleBatter(batter5,n5);
        isEligibleBatter(batter6,n6);
        isEligibleBatter(batter7,n7);
        isEligibleBatter(batter8,n8);
        isEligibleBatter(batter9,n9);
        isEligibleBatter(batter10,n10);

        isEligibleBowler(bowler1,n11);
        isEligibleBowler(bowler2,n12);
        isEligibleBowler(bowler3,n13);
        isEligibleBowler(bowler4,n14);
        isEligibleBowler(bowler5,n15);
        isEligibleBowler(bowler6,n16);
        isEligibleBowler(bowler7,n17);
        isEligibleBowler(bowler8,n18);
        isEligibleBowler(bowler9,n19);
        isEligibleBowler(bowler10,n20);*/

        batters.put(batter1,n1);
        batters.put(batter2,n2);
        batters.put(batter3,n3);
        batters.put(batter4,n4);
        batters.put(batter5,n5);
        batters.put(batter6,n6);
        batters.put(batter7,n7);
        batters.put(batter8,n8);
        batters.put(batter9,n9);
        batters.put(batter10,n10);



        this.batters=batters;
        this.bowlers=bowlers;
    }



    private boolean isEligibleBatter(Player batters, Statistics n) {
        /*if(getAge()>= 35 && getNumbers() >= 50){
            return true;
        }*/
        return false;
    }

    private void  isEligibleBowler(Player bowlers, Statistics n){

    }

    Player batter1 = new Player("Sachin", 40, "Maharashtra") ;
    Statistics n1 = new Statistics(300,15000);
    Player batter2 = new Player("Virat", 35, "Delhi") ;

    Statistics n2 = new Statistics(250 ,12000);
    Player batter3 = new Player( "Amit", 18, "Gujarat") ;
    Statistics n3 = new Statistics(45 , 3000);

    Player batter4 = new Player( "Rajesh", 30, "Gujarat") ;
    Statistics n4 = new Statistics(100 , 5000);
    Player batter5 = new Player( "Harvinder", 33, "Haryana") ;
    Statistics n5 = new Statistics(100, 5000 );
    Player batter6 = new Player("Abhi", 33, "Delhi") ;
    Statistics n6 = new Statistics(100, 7000);
    Player batter7 = new Player("Rajesh", 33, "Gujarat") ;
    Statistics n7 = new Statistics(100 , 5000);
    Player batter8 = new Player( "Srikanth", 23, "Tamilnadu") ;
    Statistics n8 = new Statistics(30, 2000);
    Player batter9 = new Player("Shankar", 26, "Tamilnadu") ;
    Statistics n9 = new Statistics( 100, 5000);
    Player batter10 = new Player("Sudan", 22, "Karnataka") ;
    Statistics n10 = new Statistics(55 , 3000);



    Player bowler1 = new Player("Jaspreet", 28, "Gujarat");
    Statistics n11 = new Statistics( 150 , 300);
    Player bowler2 = new Player("Ashwin", 34, "Karnataka");
    Statistics n12 = new Statistics(300, 450);
    Player bowler3 = new Player("Ajit", 25 , "Delhi");
    Statistics n13 = new Statistics(100, 100);
    Player bowler4 = new Player("Ravinder", 23, "Delhi");
    Statistics n14= new Statistics(80, 120);
    Player bowler5 = new Player("Amar", 29, "Delhi");
    Statistics n15 = new Statistics(120, 150);
    Player bowler6 = new Player("Mohinder", 20, "Punjab");
    Statistics n16 = new Statistics(70, 100);
    Player bowler7 = new Player("Rachin", 27, "Karnataka");
    Statistics n17= new Statistics(40, 150);
    Player bowler8 = new Player("Amar", 31, "Haryana");
    Statistics n18 = new Statistics(180, 250);
    Player bowler9 = new Player("Ajit", 32, "Maharashtra");
    Statistics n19 = new Statistics(200, 350);

    Player bowler10 = new Player("Rohit", 22, "UP");
    Statistics n20 = new Statistics(100, 180);


    /*public boolean getIsEligibleBatter(){
        return true;
    }*/



}
