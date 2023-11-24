import exam.org.Player;
import exam.org.SelectionCommittee;
import exam.org.Statistics;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Statistics s1 = new Statistics(300, 15000);
        Statistics s2 = new Statistics(250, 12000);
        Statistics s3 = new Statistics(45, 3000);
        Statistics s4 = new Statistics(100, 5000);
        Statistics s5 = new Statistics(100, 5000);
        Statistics s6 = new Statistics(100, 7000);
        Statistics s7 = new Statistics(100, 5000);
        Statistics s8 = new Statistics(30, 2000);
        Statistics s9 = new Statistics(100, 5000);
        Statistics s10 = new Statistics(55, 3000);


        Statistics ss1 = new Statistics(150,300);
        Statistics ss2 = new Statistics(300,450);
        Statistics ss3 = new Statistics(100,100);
        Statistics ss4 = new Statistics(80,120);
        Statistics ss5 = new Statistics(120,150);
        Statistics ss6 = new Statistics(70,100);
        Statistics ss7 = new Statistics(40,150);
        Statistics ss8 = new Statistics(180,250);
        Statistics ss9 = new Statistics( 200,350);
        Statistics ss10 = new Statistics(100,130);



        Player p1 = new Player("Sachin", 40, "Maharashtra",s1,"Batsman");
        Player p2 = new Player("Virat", 35, "Delhi",s2,"Batsman");
        Player p3 = new Player("Amit", 18, "Gujarat",s3,"Batsman");
        Player p4 = new Player("Rajesh", 30, "Gujarat",s4,"Batsman");
        Player p5 = new Player("Harvinder", 33, "Haryana",s5,"Batsman");
        Player p6 = new Player("Abhi", 33, "Delhi",s6,"Batsman");
        Player p7 = new Player("Rajesh1", 33, "Gujarat",s7,"Batsman");
        Player p8 = new Player("Srikanth", 23, "Tamilnadu",s8,"Batsman");
        Player p9 = new Player("Shankar", 26, "Tamilnadu",s9,"Batsman");
        Player p10 = new Player("Sudan", 22, "Karnataka",s10,"Batsman");


        Player b1 = new Player("Jaspreet", 28, "Gujarat",ss1,"Bowler");
        Player b2 = new Player("Ashwin", 34, "Karnataka",ss2,"Bowler");
        Player b3 = new Player("Ajit", 25, "Delhi",ss3,"Bowler");
        Player b4 = new Player("Ravinder", 23, "Delhi",ss4,"Bowler");
        Player b5 = new Player("Amar", 29, "Delhi",ss5,"Bowler");
        Player b6 = new Player("Mohinder", 20, "Punjab",ss6,"Bowler");
        Player b7 = new Player("Rachin", 27, "Karnataka",ss7,"Bowler");
        Player b8 = new Player("Amar", 31, "Haryana",ss8,"Bowler");
        Player b9 = new Player("Ajit", 32, "Maharashtra",ss9,"Bowler");
        Player b10 = new Player("Rohit",22,"UP",ss10,"Bowler");

        Set<Player> player = new TreeSet<>();
        player.add(p1);
        player.add(p2);
        player.add(p3);
        player.add(p4);
        player.add(p5);
        player.add(p6);
        player.add(p7);
        player.add(p8);
        player.add(p9);
        player.add(p10);
        player.add(b1);
        player.add(b2);
        player.add(b3);
        player.add(b4);
        player.add(b5);
        player.add(b6);
        player.add(b7);
        player.add(b8);
        player.add(b9);
        player.add(b10);



//        Set<Player> bowler=new TreeSet<>();
//        bowler.add(b1);
//        bowler.add(b2);
//        bowler.add(b3);
//        bowler.add(b4);
//        bowler.add(b5);
//        bowler.add(b6);
//        bowler.add(b7);
//        bowler.add(b8);
//        bowler.add(b9);
//        bowler.add(b10);




//        for(Player k: player){
//            System.out.println(k);
//        }

        SelectionCommittee sc=new SelectionCommittee();
        sc.addPlayers(player);
//        sc.addBowler(bowler);

        System.out.println(">>>>>>>>>>>>>>>>Selected players");
        for(Player t1: sc.getPlay()){
            System.out.println(t1);
        }

//        System.out.println(">>>>>>>>>>>>>>>>Selected bowler player");
//        for(Player t1: sc.getBow()){
//            System.out.println(t1);
//        }

    }
}