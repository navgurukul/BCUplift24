

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class WorldcupSelection{


    Map<Player,Double> Batsmen = new HashMap<>();
    Map<Player,Double> Bowlers = new HashMap<>();
    
    Player p1 = new Player("Sachin",40,Maharashtra);
    Statistics s1 = new Statistics(300,15000);
    
    Player p2 = new Player("Virat", 35,Delhi);
    Statistics s2 = new Staticstics(250,12000);
    
    Player p3 = new Player("Amit",18,"Gujarat");
    Statistics s3 = new Staticstics(45,3000);
    
    Player p4 = new Player("Rajesh",30,"Gujarat");
    Statistics s4 = new Statistics(100,5000);
    
    player p5 = new Player("Harvinder",33,"Haryana");
    Statistics s5 = new Statistics(100,5000);
    
    Player p6 = new Player("Abhi",33,"Delhi");
    Statistics s6 = new Staticstics(100,7000);
    
    Player p7 = new Player("Rajesh",33,"Gujarat");
    Statistics s7 = new Staticstics(100,5000);
    
    Player p8 = new Player("Srikanth",23,"Tamilnadu");
    Statistics s8 = new Staticstics(30,2000);
    
    Player p9 = new Player("Shankar",26,"Tamilnadu");
    Statistics s9 = new Statistics(100,5000);
    
    Player p10 = new Player("Sudan",22,"Karnataka");
    Statistics s10 = new Statistics(55,3000);
    
    
    Batsmen.put(p1,s1.calculateAverage());
    Batsmen.put(p2,s2.calculateAverage());
    Batsmen.put(p3,s3.calculateAverage);
    Batsmen.put(p4,s4.calculateAverage());
    Batsmen.put(p5,s5.calculateAverage());
    Batsmen.put(p6,s6.calculateAverage());
    Batsmen.put(p7,s7.calculateAverage());
    Batsmen.put(p8,s8.calculateAverage());
    Batsmen.put(p9,s9.calculateAverage());
    Batsmen.put(p10,s10.calculateAverage());
    
    Player p11 = new Player("Jaspreet",28,"Gujarat");
    Statistics s11 = new Statistics(150,300);
    
    Player p12 new Player("Ashwin",34,"Karnataka");
    Statistics s12 = new Statistics(300,450);
    
    Player p13 = new Player("Ajit",25,"Delhi");
    Statistics s13 = new Statistics(100,100);
    
    Player p14 = new Player("Ravinder",23,"Delhi");
    Statistics s14 = new Statistics(80,120);
    
    Player p15 = new Player("Amar",29,"Delhi");
    Statistics s15 = new Statistics(120,150);
    
    Player p16 = new Player("Mohinder",20,"Punjab");
    Statistics s16 = new Statistics(70,100);
    
    Player p17 = new Player("Rachin",27,"Karnataka");
    Statistics s17 = new Statistics(40,150);
    
    Player p18 = new Player("Amar",31,"Haryana");
    Statistics s18 = new Statistics(180,250);
    
    Player p19 = new Player("Ajit",32,"Maharashtra");
    Statistics s19 = new Statistics(200,350);
    
    Player p20 = new Player("Rohit",22,"UP");
    Statistics s20 = new Statistics(100,130);
    
    
    Bowlers.put(p11,s11.calculateAverage());
    Bowlers.put(p12,s12.calculateAverage());
    Bowlers.put(p13,s13.calculateAverage());
    Bowlers.put(p14,s14.calculateAverage());
    Bowlers.put(p15,s15.calculateAverage());
    Bowlers.put(p16,s16.calculateAverage());
    Bowlers.put(p17,s17.calculateAverage());
    Bowlers.put(p18,s18.calculateAverage());
    Bowlers.put(p19,s19.calculateAverage());
    Bowlers.put(p20,s20.calculateAverage());
    
    
    StatsManager sm = new StatsManager(Batsmen,Bowlers);
}





class Player{
    private String name;
    private int age;
    private String state;
    
    public Player(String name, int age, String state)
    {
        this.name = name;
        this.age = age;
        this.state = state;
    }
    
    public String toString()
    {
        return "Player Name = "+name+", Age = "+age+", State = "+age;
        
    }
    
    
}




class Statistics{

    private int noOfMatches;
    private int number;

    public Statistics(int noOfMatches,int number)
    {
        this.noOfMatches = noOfMatches;
        this.number = number;
    }
    
    Double public calculateAverage()
    {
        return number/noOfMatches; 
    }
}





class StatsManager{
    
    private Map<Player,Double> Batsmen = new HashMap<>();
    private Map<Player,Double> Bowlers = new HashMap<>();
    
    
    public StatsManager(Map<Player,Double> Batsmen, Map<Player,Double> Bowlers)
    {
        this.Batsmen = Batsmen;
        this.Bowlers = Bowlers;
        
    }
    
    

}
  