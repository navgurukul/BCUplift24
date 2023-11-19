import org.uplift.teamSelection.Players;
import org.uplift.teamSelection.SelectionCommittee;
import org.uplift.teamSelection.Statistics;
import org.uplift.teamSelection.StatsManager;

public class Main {
    public static void main(String[] args) {
        Players p1= new Players("Sachin","Maharashtra",40);
        Players p2= new Players("virat","Delhi",35);
        Players p3= new Players("Amit","Gujarat",18);
        Players p4= new Players("Rajesh","Gujarat",30);
        Players p5= new Players("Harvinder","Haryana",33);
        Players p6= new Players("Abhi","Delhi",33);
        Players p7= new Players("Rajesh","Gujarat",33);
        Players p8= new Players("Srikanth","Tamil Nadu",23);
        Players p9= new Players("Shankar","Tamil Nadu",26);
        Players p10= new Players("Sudan","Karnataka",22);

        Players pb1= new Players("Jaspreet"," Gujarat",28);
        Players pb2= new Players("Ashwin","Karnataka",34);
        Players pb3= new Players("Ajit"," Delhi",25);
        Players pb4= new Players("Ravinder"," Delhi",23);
        Players pb5= new Players("Amar"," Delhi",29);
        Players pb6= new Players("Mohinder"," punjab",20);
        Players pb7= new Players("Rachin"," Karnataka",27);
        Players pb8= new Players("Amar"," Haryana",31);
        Players pb9= new Players("Ajit"," Maharashtra",32);
        Players pb10= new Players("Rohit"," UP",22);

//        StatsManager sm1= new StatsManager();
        SelectionCommittee sc1= new SelectionCommittee();
        sc1.calcBatsmanPerformance(p1);
        sc1.calcBatsmanPerformance(p2);
        sc1.calcBatsmanPerformance(p3);
        sc1.calcBatsmanPerformance(p4);
        sc1.calcBatsmanPerformance(p5);
        sc1.calcBatsmanPerformance(p6);
        sc1.calcBatsmanPerformance(p7);
        sc1.calcBatsmanPerformance(p8);
        sc1.calcBatsmanPerformance(p9);
        sc1.calcBatsmanPerformance(p10);



        System.out.println(calcBatsManPerformance(sc1));



    }

    private static boolean calcBatsManPerformance(SelectionCommittee sc1) {
        return false;
    }


}
//        Bowlers:
//        1) Jaspreet, 28 years, Gujarat, 150 matches, 300 wickets
//        2) Ashwin, 34 years, Karnataka, 300 matches, 450 wickets
//        3) Ajit, 25 years, Delhi, 100 matches, 100 wickets
//        4) Ravinder, 23 years, Delhi, 80 matches, 120 wickets
//        5) Amar, 29 years, Delhi, 120 matches, 150 wickets
//        6) Mohinder, 20 years, Punjab, 70 matches, 100 wickets
//        7) Rachin, 27 years, Karnataka, 40 matches, 150 wickets
//        8) Amar, 31 years, Haryana, 180 matches, 250 wickets
//        9) Ajit, 32 years, Maharashtra, 200 matches, 350 wickets
//        10) Rohit, 22 years, UP, 100 matches, 130 wickets
//
//Batsmen:
//        1) Sachin, 40 years, Maharashtra, 300 matches, 15,000 runs,
//        2) Virat, 35 years, Delhi, 250 matches, 12,000 runs
//        3) Amit, 18 years, Gujarat, 45 matches, 3,000 runs
//        4) Rajesh, 30 years, Gujarat, 100 matches, 5,000 runs
//        5) Harvinder, 33 years, Haryana, 100 matches, 5,000 runs
//        6) Abhi, 33 years, Delhi, 100 matches, 7,000 runs
//        7) Rajesh, 33 years, Gujarat, 100 matches, 5,000 runs
//        8) Srikanth, 23 years, Tamilnadu, 30 matches, 2,000 runs
//        9) Shankar, 26 years, Tamilnadu, 100 matches, 5,000 runs
//        10) Sudan, 22 years, Karnataka, 55 matches, 3,000 runs
//
