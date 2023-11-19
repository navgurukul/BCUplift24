import PracticeExam.Batter;
import PracticeExam.Player;
import PracticeExam.Statistics;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> batterList = ArrayList<>();
        Map<Player, Statistics> batterMap = new HashMap<>();
        Player p1 = new Batter("Sachin", 40, "Maharashtra");
        Statistics s1 = new Statistics(300, 15000);

        Player p2 = new Batter("Virat",35, "Delhi");
        Statistics s2 = new Statistics(250, 12000);

        Player p3 = new Batter("Amit",18, "Gujarat");
        Statistics s3 = new Statistics(45, 3000);

        Player p4 = new Batter("Rajesh",30, "Gujarat");
        Statistics s4 = new Statistics(100, 5000);

        Player p5 = new Batter("Harvinder",33, "Haryana");
        Statistics s5 = new Statistics(100, 5000);

        Player p6 = new Batter("Abhi",33, "Delhi");
        Statistics s6 = new Statistics(100, 7000);

        Player p7 = new Batter("Rajesh",33, "Gujarat");
        Statistics s7 = new Statistics(100, 5000);

        Player p8 = new Batter("Srikanth",23, "TamilNadu");
        Statistics s8 = new Statistics(30, 2000);

        Player p9 = new Batter("Shankar",26, "TamilNadu");
        Statistics s9 = new Statistics(100, 5000);

        Player p10 = new Batter("Sudan",22, "Karnataka");
        Statistics s10 = new Statistics(55, 3000);

        batterList.append(p1);
        batterList.append(p2);
        batterList.append(p3);
        batterList.apeend(p4);
        batterList.append(p5);
        batterList.append(p6);
        batterList.append(p7);
        batterList.append(p8);
        batterList.append(p9);
        batterList.append(s10);

        boolean isEligible = false;
        while(true){
            if(i.getAge() < 35){
                isEligible = true;
            }
        }

        batterMap.put(p1, s1);
        batterMap.put(p2, s2);
        batterMap.put(p3, s3);
        batterMap.put(p4, s4);
        batterMap.put(p5, s5);
        batterMap.put(p6, s6);
        batterMap.put(p7, s7);
        batterMap.put(p8, s8);
        batterMap.put(p9, s9);
        batterMap.put(p10, s10);

        System.out.println(batterMap);

    }
}