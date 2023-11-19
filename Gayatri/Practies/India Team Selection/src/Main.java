import org.criketSelection.Players;
import org.criketSelection.Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //ArrayList<Players> players = new ArrayList<>();
        Map<Players,Statistic> batsMan=new HashMap<>();
        Statistic s1=new Statistic(300,12000);
        Players p1 =new Players("Virat",35,"Delhi");
        batsMan.put(p1,s1);

        Statistic s2=new Statistic(250,12000);
        Players p2 =new Players("Sachin",30,"Maharashrta");
        batsMan.put(p2,s2);

        Statistic s3=new Statistic(45,3000);
        Players p3 =new Players("Amit",18,"Gujrat");
        batsMan.put(p3,s3);

        Statistic s4=new Statistic(100,5000);
        Players p4 =new Players("Rajesh",30,"Haryana");
        batsMan.put(p4,s4);

        Statistic s5=new Statistic(100,7000);
        Players p5 =new Players("Harvinder",33,"Haryana");
        batsMan.put(p5,s5);

       Statistic s6=new Statistic(100,7000);
        Players p6 =new Players("Abhi",33,"Delhi");
        batsMan.put(p6,s6);

        Statistic s7=new Statistic(100,5000);
        Players p7 =new Players("Rajesh",33,"Gujrat");
        batsMan.put(p7,s7);

        Statistic s8=new Statistic(30,2000);
        Players p8 =new Players("Srikant",23,"Tamilnadu");
        batsMan.put(p8,s8);

        Statistic s9=new Statistic(100,5000);
        Players p9 =new Players("Shanker",26);
        batsMan.put(p9,s9);

        Statistic s10=new Statistic(55,3000);
        Players p10 =new Players("Sudan",22,"Karnataka");
        batsMan.put(p10,s10);

        Map<Players,Statistic> bowlwer =new HashMap<>();
        Statistic s11=new Statistic(300,15000);
        Players p11 =new Players("Jaspreet",28,"Gujrat");
        bowlwer.put(p11,s11);

        /*Statistic s12=(300,15000);
        Players p12=("Sachin","Maharashrta",30,s1);
        bowlwer.put(p12,s12);

        Statistic s13=(300,15000);
        Players p13 =("Sachin","Maharashrta",30,s1);
        bowlwer.put(p13,s13);

        Statistic s14=(300,15000);
        Players p14=("Sachin","Maharashrta",30,s1);
        bowlwer.put(p14,s14);

        Statistic s15=(300,15000);
        Players p15 =("Sachin","Maharashrta",30,s1);
        bowlwer.put(p15,s15);

        Statistic s16=(300,15000);
        Players p16 =("Sachin","Maharashrta",30,s1);
        bowlwer.put(p16,s16);

        Statistic s17=(300,15000);
        Players p17 =("Sachin","Maharashrta",30,s1);
        bowlwer.put(p17,s17);

        Statistic s18=(300,15000);
        Players p18 =("Sachin","Maharashrta",30,s1);
        bowlwer.put(p18,s18);

        Statistic s19=(300,15000);
        Players p19 =("Sachin","Maharashrta",30,s1);
        bowlwer.put(p19,s19);

        Statistic s20=(300,15000);
        Players p20 =("Sachin","Maharashrta",30,s1);
        bowlwer.put(p20,s20);

        */









    }
}