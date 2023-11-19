package org.uplift.IndianTeamSelection;
import org.uplift.IndianTeamSelection.Player;
import org.uplift.IndianTeamSelection.Statistics;
import org.uplift.IndianTeamSelection.StatisticsManager;

import java.util.HashMap;
import java.util.Map;




public class CreatePlayersAndStatistics {
    public Map<Player,Statistics> batsman=new HashMap<>();
    public Map<Player,Statistics> bowler=new HashMap<>();

    StatisticsManager sm=new StatisticsManager();
        Player batsman1=new Player("Sachin", 40 , "Maharashtra");
        Statistics batsmanStats1=new Statistics(300,15000);

        sm.createBatsman(batsman1,batsmanStats1);
        Player batsman2=new Player("Virat", 35, "Delhi");
        Statistics batsmanStats2=new Statistics(250,12000);
        sm.createBatsman(batsman2,batsmanStats2);
        Player batsman3=new Player("Amit", 18 , "Gujarat");
        Statistics batsmanStats3=new Statistics(45,3000);
         sm.createBatsman(batsman3,batsmanStats3);

        Player batsman4=new Player("Rajesh", 30, "Gujarat");
        Statistics batsmanStats4=new Statistics(100,5000);
         sm.createBatsman(batsman4,batsmanStats4);

        Player batsman5=new Player("Harvinder", 33, "Haryana");
        Statistics batsmanStats5=new Statistics(100,5000);
         sm.createBatsman(batsman5,batsmanStats5);
        Player batsman6=new Player("Abhi", 33, "Delhi");
    Statistics batsmanStats6=new Statistics(100,7000);
     sm.createBatsman(batsman6,batsmanStats6);

        Player batsman7=new Player("Rajesh", 33 , "Gujarat");
    Statistics batsmanStats7=new Statistics(100,5000);
     sm.createBatsman(batsman7,batsmanStats7);

    Player batsman8=new Player("Srikanth", 23, "Tamilnadu");
    Statistics batsmanStats8=new Statistics(30,2000);
     sm.createBatsman(batsman8,batsmanStats8);

    Player batsman9=new Player("Shankar", 26 , "Tamilnadu");
    Statistics batsmanStats9=new Statistics(100,5000);
     sm.createBatsman(batsman9,batsmanStats9);

    Player batsman10=new Player("Sudan", 22 , "Karnataka");
    Statistics batsmanStats10=new Statistics(55,3000);
     sm.createBatsman(batsman10,batsmanStats10);





    Player bowler1=new Player("Jaspreet", 28, "Gujarat",);
    Statistics bowlerStats1=new Statistics(150,300);

    Player bowler2=new Player("Ashwin", 34, "Karnataka");
    Statistics bowlerStats2=new Statistics(300,450);
    Player bowler3=new Player("Ajit", 25, "Delhi");
    Statistics bowlerStats3=new Statistics(100,100);

    Player bowler4=new Player( "Ravinder", 23, "Delhi",);
    Statistics bowlerStats4=new Statistics(80,120);
    Player bowler5=new Player( "Amar", 29, "Delhi");
    Statistics bowlerStats5=new Statistics(120,150);

    Player bowler6=new Player("Mohinder", 20, "Punjab");
    Statistics bowlerStats6=new Statistics(70,100);
    Player bowler7=new Player("Rachin", 27, "Karnataka");
    Statistics bowlerStats7=new Statistics(40,150);

    Player bowler8=new Player("Amar", 31, "Haryana");
    Statistics bowlerStats8=new Statistics(180,250);

    Player bowler9=new Player("Ajit", 32, "Maharashtra");
    Statistics bowlerStats9=new Statistics(200,350);

    Player bowler10=new Player("Rohit", 22, "UP");
    Statistics bowlerStats10=new Statistics(100,130);


}
