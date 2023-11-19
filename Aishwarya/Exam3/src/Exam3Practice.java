import java.util.HashMap;
import java.util.Map;

public class Exam3Practice {
    public static void main(String[] args) {

       Map<Players, Statistics> bowlersmap = new HashMap<>();

        Players p1= new Players("Sachin","40 years","Maharashtra");
        Statistics s1 = new  Statistics(300,15000);
        bowlersmap(p1,s1);

        Players p2= new Players("Virat","35 years","Delhi");
        Statistics s2 = new  Statistics(250,12000);
        bowlersmap(p2,s2);

        Players p3= new Players("Amit","18 years","Gujrat");
        Statistics s3 = new  Statistics(45,3000);
        bowlersmap(p3,s3);

        Players p4= new Players("Harvindar","33 years","Gujrat");
        Statistics s4 = new  Statistics(100,5000);
        bowlersmap(p4,s4);

        Players p5= new Players("Jaspreet","28 years","Gujarat");
        Statistics s5 = new  Statistics(250,15000);
        bowlersmap(p5,s5);

        Map<Players,Statistics >batsmansmap= new HashMap<>();

        Players p6= new Players("mohindar","20 years","Punjab");
        Statistics s6 = new  Statistics(100,100);
        batsmansmap(p6,s6);

        Players p7= new Players("Rachin","27 years","Karnataka");
        Statistics s7 = new  Statistics(80,120);
        batsmansmap(p7,s7);


    }
}