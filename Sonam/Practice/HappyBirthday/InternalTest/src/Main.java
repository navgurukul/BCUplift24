import org.uplift.indianTeamSelection.Player;
import org.uplift.indianTeamSelection.SelectionCommity;
import org.uplift.indianTeamSelection.StateManager;
import org.uplift.indianTeamSelection.Statistic;

public class Main {
    public static void main(String[] args) {
        Statistic batterS1=new Statistic(300,15000);
        Player batter1= new Player("Sachin",40,"Maharashtra");

        Statistic batterS2=new Statistic(250,12000);
        Player batter2= new Player("Virat",35,"Delhi");

        Statistic batterS3=new Statistic(45,3000);
        Player batter3= new Player("Amit",18,"Gujarat");

        Statistic batterS4=new Statistic(100,5000);
        Player batter4= new Player("Rajesh",30,"Gujrat");

        Statistic batterS5=new Statistic(100,5000);
        Player batter5= new Player("Harvinder",33,"Haryana");

        Statistic batterS6=new Statistic(100,7000);
        Player batter6= new Player("Abhi",33,"Delhi");

        Statistic batterS7=new Statistic(100,5000);
        Player batter7= new Player("Rajesh",33,"Gujrat");

        Statistic batterS8=new Statistic(30,2000);
        Player batter8= new Player("Srikant",23,"Tamilnadu");

        Statistic batterS9=new Statistic(100,5000);
        Player batter9= new Player("Shankar",26,"Tamilnadu");

        Statistic batterS10=new Statistic(55,3000);
        Player batter10= new Player("Sudan",22,"Karnataka");

        StateManager s1=new StateManager();
        s1.addBollers(batter1,batterS1);
        s1.addBollers(batter2,batterS2);
        s1.addBollers(batter3,batterS3);
        s1.addBollers(batter4,batterS4);
        s1.addBollers(batter5,batterS5);
        s1.addBollers(batter6,batterS6);
        s1.addBollers(batter7,batterS7);
        s1.addBollers(batter8,batterS8);
        s1.addBollers(batter9,batterS9);
        s1.addBollers(batter10,batterS10);

        //Bollerrs
        Statistic bollerS1=new Statistic(150,300);
        Player Boller1= new Player("Jaspreet",28,"Gujrat");

        Statistic bollerS2=new Statistic(300,450);
        Player Boller2= new Player("Ashwin",34,"Karnataka");

        Statistic bollerS3=new Statistic(100,100);
        Player Boller3= new Player("Ajit",25,"Delhi");

        Statistic bollerS4=new Statistic(80,120);
        Player Boller4= new Player("Ravindar",23,"Delhi");

        Statistic bollerS5=new Statistic(120,150);
        Player Boller5= new Player("Amar",29,"Delhi");

        Statistic bollerS6=new Statistic(70,100);
        Player Boller6= new Player("Mohindar",20,"Panjab");

        Statistic bollerS7=new Statistic(40,150);
        Player Boller7= new Player("Rachin",27,"Karnataka");

        Statistic bollerS8=new Statistic(180,250);
        Player Boller8= new Player("Amar",31,"Haryana");

        Statistic bollerS9=new Statistic(200,350);
        Player Boller9= new Player("Ajit",32,"Maharashtra");

        Statistic bollerS10=new Statistic(100,130);
        Player Boller10= new Player("Rohit",22,"UP");

        s1.addBatters(Boller1,bollerS1);
        s1.addBatters(Boller2,bollerS2);
        s1.addBatters(Boller3,bollerS3);
        s1.addBatters(Boller4,bollerS4);
        s1.addBatters(Boller5,bollerS5);
        s1.addBatters(Boller6,bollerS6);
        s1.addBatters(Boller7,bollerS7);
        s1.addBatters(Boller8,bollerS8);
        s1.addBatters(Boller9,bollerS9);
        s1.addBatters(Boller10,bollerS10);

        System.out.println(s1.getBatters());
        System.out.println(s1.getBollers());

        SelectionCommity selectionCommity=new SelectionCommity();


    }
}