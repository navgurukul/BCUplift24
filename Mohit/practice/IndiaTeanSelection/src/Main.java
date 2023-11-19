import india.team.selection.programm.Player;
import india.team.selection.programm.SelectionCommitee;
import india.team.selection.programm.Statistics;

import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SelectionCommitee sc1=new SelectionCommitee();
        Statistics s1=new Statistics(300,150000);
        Statistics s2=new Statistics(45,3000);
        Statistics s3=new Statistics(100,3000);
        Statistics s4=new Statistics(100,5000);
        Statistics s5=new Statistics(55,2000);
        Statistics s6=new Statistics(50,150000);
        Statistics s7=new Statistics(45,4000);

        Statistics s8=new Statistics(150,300);
        Statistics s9=new Statistics(34,450);
        Statistics s10=new Statistics(80,120);
        Statistics s11=new Statistics(70,100);
        Statistics s12=new Statistics(180,200);
        Statistics s13=new Statistics(100,180);
        Statistics s14=new Statistics(250,400);



        Player p1=new Player("Sachin", 40 , "Maharashtra");
        Player p2=new Player("deepak", 35 , "delhi");
        Player p3=new Player("virat", 18, "Gujarat");
        Player p4=new Player("amit", 30, "gujarat");
        Player p5=new Player("Sajesh", 33 , "Tamilnadu");
        Player p6=new Player("kohali", 33 , "Tamilnadu");
        Player p7=new Player("mohamad", 23 , "Karnatika");


        Player p8=new Player("Ikbal", 28 , "Karnatika");
        Player p9=new Player("Ankit", 34 , "Punjab");
        Player p10=new Player("Rajkumar", 25 , "haryana");
        Player p11=new Player("Sunny", 20, "Delhi");
        Player p12=new Player("Mukesh", 27 , "Up");
        Player p13=new Player("Sujit", 32, "Karnatika");
        Player p14=new Player("monu", 23 , "Delhi");

        HashMap<Player,Statistics>batsman=new HashMap<>();
        batsman.put(p1,s1);
        batsman.put(p2,s2);
        batsman.put(p3,s3);
        batsman.put(p4,s4);
        batsman.put(p5,s5);
        batsman.put(p6,s6);
        batsman.put(p7,s7);

        HashMap<Player,Statistics>bowler=new HashMap<>();
        bowler.put(p8,s8);
        bowler.put(p9,s9);
        bowler.put(p10,s10);
        bowler.put(p11,s11);
        bowler.put(p12,s12);
        bowler.put(p13,s13);
        bowler.put(p14,s14);
        sc1.addPlayer(p1);
        System.out.println(sc1.getStoreplayer());






    }


}