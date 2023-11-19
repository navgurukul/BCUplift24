import org.Player;
import org.Statistics;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Player, Statistics> batsmanMap= new HashMap<>();
        Map<Player,Statistics> bowlerMap= new HashMap<>();

        Player player1 = new Player("Sachin", 40, "Maharashtra");
        Player player2 = new Player("Virat", 35, "Delhi");
        Player player3 = new Player("Amit", 18, "Gujarat");
        Player player4 = new Player(" Rajesh", 30, "Gujarat");
        Player player5 = new Player("Harvinder", 33, "Haryana");
        Player player6 = new Player("Abhi", 33, "Haryana");
        Player player7 = new Player("Rajesh", 33, "Gujarat");
        Player player8 = new Player("Srikanth", 23, "Tamilnadu");
        Player player9 = new Player("Shankar", 26, "Tamilnadu");
        Player player10 = new Player("Sudan", 22, "Karnataka");
        Player player11 = new Player("Jaspreet", 28, "Gujarat");
        Player player12 = new Player("Ashwin", 34, "Karnataka");
        Player player13 = new Player(" Ajit", 25, "Delhi");
        Player player14 = new Player(" Ravinder", 23, "Delhi");
        Player player15 = new Player("Amar", 29, "Delhi");
        Player player16 = new Player("Mohinder", 20, "Punjab");
        Player player17 = new Player("Rachin", 27, "Karnataka");
        Player player18 = new Player("Amar", 31, "Haryana");
        Player player19 = new Player("Ajit", 32, "Maharashtra");
        Player player20 = new Player("Rohit", 22, "UP");


        Statistics s1=new Statistics(300,15000);
        Statistics s2=new Statistics(250, 12000);
        Statistics s3=new Statistics(45, 3000);
        Statistics s4=new Statistics(100, 5000);
        Statistics s5=new Statistics(100, 5000);
        Statistics s6=new Statistics(100, 7000);
        Statistics s7=new Statistics(100, 5000);
        Statistics s8=new Statistics(30, 2000);
        Statistics s9=new Statistics(100, 5000);
        Statistics s10=new Statistics(55, 3000);
        Statistics s11=new Statistics(150, 300);
        Statistics s12=new Statistics(300, 450);
        Statistics s13=new Statistics(100, 100);
        Statistics s14=new Statistics(80, 120);
        Statistics s15=new Statistics(120, 150);
        Statistics s16=new Statistics(70, 100);
        Statistics s17=new Statistics(40, 150);
        Statistics s18=new Statistics(180, 250);
        Statistics s19=new Statistics(200, 350);
        Statistics s20=new Statistics(100, 130);

        batsmanMap.put(player1,s1);
        batsmanMap.put(player2,s2);
        batsmanMap.put(player3,s3);
        batsmanMap.put(player4,s4);
        batsmanMap.put(player5,s5);
        batsmanMap.put(player6,s6);
        batsmanMap.put(player7,s7);
        batsmanMap.put(player8,s8);
        batsmanMap.put(player9,s9);
        batsmanMap.put(player10,s10);

        bowlerMap.put(player11,s11);
        bowlerMap.put(player12,s12);
        bowlerMap.put(player13,s13);
        bowlerMap.put(player14,s14);
        bowlerMap.put(player15,s15);
        bowlerMap.put(player16,s16);
        bowlerMap.put(player17,s17);
        bowlerMap.put(player18,s18);
        bowlerMap.put(player19,s19);
        bowlerMap.put(player20,s20);

        System.out.println(batsmanMap);
        System.out.println(bowlerMap);




    }


}