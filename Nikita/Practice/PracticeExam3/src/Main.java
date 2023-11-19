
import javafx.scene.layout.BorderWidths;
import org.uplift24.PracticeExample.Player;
import org.uplift24.PracticeExample.StatisticManager;
import org.uplift24.PracticeExample.Statistics;

import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Player Batsmen1=new Player("Sachin",40,"Maharashtra");
        Statistics s1=new Statistics(300,15000);

        Player Batsmen2=new Player("Virat",35,"Delhi");
        Statistics s2=new Statistics(250,12000);

        Player Batsmen3=new Player("Amit",18,"Gujarat");
        Statistics s3=new Statistics(45,3000);

        Player Batsmen4=new Player("Rajesh",30,"Gujarat");
        Statistics s4=new Statistics(100,5000);

        Player Batsmen5=new Player("Harvinder",30,"Gujarat");
        Statistics s5=new Statistics(100,5000);

        Player Batsmen6=new Player("Abhi",33,"Haryana");
        Statistics s6=new Statistics(100,7000);

        Player Batsmen7=new Player("Rajesh",33,"Gujarat");
        Statistics s7=new Statistics(300,15000);

        Player Batsmen8=new Player("Shanker",26,"Tamilnadu");
        Statistics s8=new Statistics(300,15000);

        Player Batsmen9=new Player("Shreekant",23,"Tamilnadu");
        Statistics s9=new Statistics(100,5000);

        Player Batsmen10=new Player("Sudan",22,"Karnataka");
        Statistics s10=new Statistics(55,3000);

        Map<Player,Statistics> m1=new HashMap<>();
        m1.put(Batsmen1,s1);
        m1.put(Batsmen2,s2);
        m1.put(Batsmen3,s3);
        m1.put(Batsmen4,s4);
        m1.put(Batsmen5,s5);
        m1.put(Batsmen6,s6);
        m1.put(Batsmen7,s7);
        m1.put(Batsmen8,s8);
        m1.put(Batsmen9,s9);
        m1.put(Batsmen10,s10);

        Player Bowler1=new Player("Jaspreet",28,"Gujrat");
        Statistics bs1=new Statistics(150,300);

        Player Bowler2=new Player("Ashwin",34,"Karnataka");
        Statistics bs2=new Statistics(300,450);

        Player Bowler3=new Player("Ajit",28,"Gujrat");
        Statistics bs3=new Statistics(100,100);

        Player Bowler4=new Player("Ravinder",23,"Delhi");
        Statistics bs4=new Statistics(80,120);

        Player Bowler5=new Player("Amar",29,"Delhi");
        Statistics bs5=new Statistics(120,150);

        Player Bowler6=new Player("Mohinder",20,"Punjab");
        Statistics bs6=new Statistics(70,100);

        Player Bowler7=new Player("Rachin",27,"Karnataka");
        Statistics bs7=new Statistics(40,150);

        Player Bowler8=new Player("Amar",31,"Haryana");
        Statistics bs8=new Statistics(180,250);

        Player Bowler9=new Player("Ajit",32,"Maharashtra");
        Statistics bs9=new Statistics(200,350);

        Player Bowler10=new Player("Rohit",22,"UP");
        Statistics bs10=new Statistics(100,130);



        }
    }
}