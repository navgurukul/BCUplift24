import org.Player;
import org.Statistic;

import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Player Batsman1 = new Player("Sachin", 40, "Maharashtra");
        Player Batsman2 = new Player("Virat", 35, "Delhi");
        Player Batsman3 = new Player("Amit", 18, "Gujarat");
        Player Batsman4 = new Player("Rajesh", 30, "Gujarat");
        Player Batsman5 = new Player("Harvinder", 33, "Haryan");
        Player Batsman6 = new Player("Abhi", 33, "Delhi");
        Player Batsman7 = new Player("Rajesh", 33, "Gujarat");
        Player Batsman8 = new Player("Srikanth", 23, "Tamilnadu");
        Player Batsman9 = new Player("Shankar", 26, "Tamilnadu");
        Player Batsman10 = new Player("Sudan", 22, "Karnataka");

        Statistic BatsmanS1 = new Statistic(300, 15000);
        Statistic BatsmanS2 = new Statistic(250, 12000);
        Statistic BatsmanS3 = new Statistic(45, 3000);
        Statistic BatsmanS4 = new Statistic(100, 5000);
        Statistic BatsmanS5 = new Statistic(100, 5000);
        Statistic BatsmanS6 = new Statistic(100, 7000);
        Statistic BatsmanS7 = new Statistic(100, 5000);
        Statistic BatsmanS8 = new Statistic(30, 2000);
        Statistic BatsmanS9 = new Statistic(100, 5000);
        Statistic BatsmanS10 = new Statistic(55, 3000);

        Map<Player, Statistic> batsmanMap = new HashMap<>();

        batsmanMap.put(Batsman1, BatsmanS1);
        batsmanMap.put(Batsman2, BatsmanS2);
        batsmanMap.put(Batsman3, BatsmanS3);
        batsmanMap.put(Batsman4, BatsmanS4);
        batsmanMap.put(Batsman5, BatsmanS5);
        batsmanMap.put(Batsman6, BatsmanS6);
        batsmanMap.put(Batsman7, BatsmanS7);
        batsmanMap.put(Batsman8, BatsmanS8);
        batsmanMap.put(Batsman9, BatsmanS9);
        batsmanMap.put(Batsman10, BatsmanS10);

        Player Bowler1 = new Player("Jaspreet", 28, "Gujarat");
        Player Bowler2 = new Player("Ashwin", 34, "Karnataka");
        Player Bowler3 = new Player("Ajit", 25, "Delhi");
        Player Bowler4 = new Player("Ravinder", 23, "Delhi");
        Player Bowler5 = new Player("Amar", 29, "Delhi");
        Player Bowler6 = new Player("Mohinder", 20, "Punjab");
        Player Bowler7 = new Player("Rachin", 27, "Karnataka");
        Player Bowler8 = new Player("Amar", 31, "Haryana");
        Player Bowler9 = new Player("Ajit", 32, "Maharashtra");
        Player Bowler10 = new Player("Rohit", 22, "UP");

        Statistic BowlerS1 = new Statistic(150, 300);
        Statistic BowlerS2 = new Statistic(3000, 450);
        Statistic BowlerS3 = new Statistic(100, 100);
        Statistic BowlerS4 = new Statistic(80, 120);
        Statistic BowlerS5 = new Statistic(120, 150);
        Statistic BowlerS6 = new Statistic(70, 100);
        Statistic BowlerS7 = new Statistic(40, 150);
        Statistic BowlerS8 = new Statistic(180, 250);
        Statistic BowlerS9 = new Statistic(200, 350);
        Statistic BowlerS10 = new Statistic(100, 130);


        Map<Player, Statistic> bowlerMap = new HashMap<>();

        bowlerMap.put(Bowler1, BowlerS1);
        bowlerMap.put(Bowler2, BowlerS2);
        bowlerMap.put(Bowler3, BowlerS3);
        bowlerMap.put(Bowler4, BowlerS4);
        bowlerMap.put(Bowler5, BowlerS5);
        bowlerMap.put(Bowler6, BowlerS6);
        bowlerMap.put(Bowler7, BowlerS7);
        bowlerMap.put(Bowler8, BowlerS8);
        bowlerMap.put(Bowler9, BowlerS9);
        bowlerMap.put(Bowler10, BowlerS10);
        System.out.println("1");

    }
}