import java.util.*;
class Player{
	private String name;
	private int age;
	private String state;
	Player(String name,int age,String state){
		this.name=name;
		this.age=age;
		this.state=state;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getState(){
		return state;
	}
	/*public String compareTo(player other) {

        if (player.calculateAvarage() !=other.calculateAvarage()) {
            return String.compare(, otherNetWorth);
        } else {
            return this.accountJoinDate.compareTo(other.accountJoinDate);
        }*/
    
}
class Statistics{
	private int noOfMatches;
	private int noOfPerformence;
	Statistics(int noOfMatches,int noOfPerformence){
		this.noOfMatches=noOfMatches;
		this.noOfPerformence=noOfPerformence;
	}
	public int  getNOfPerformence(){
		return  noOfPerformence;
	}
	public int getNoOfMatches(){
		return noOfMatches;
	}
	public double calculateAvarage(){
		return noOfMatches/noOfPerformence;
	}
}

class StaticManager{
	private Map<Player,Statistics> batsMan;
	private Map<Player,Statistics> bowlerMan;
	StaticManager(){
		this.batsMan=new HashMap<>();
		this.bowlerMan=new HashMap<>();
	}
	public Map<Player,Statistics> getBatsMan(){
		return batsMan;
	}
	public Map<Player,Statistics> getBowlerMan(){
		return  bowlerMan;
	}
	public void addBaters(Player player,Statistics statistics){
		batsMan.put(player,statistics);
	}
	public void addBowlers(Player player,Statistics statistics){
		batsMan.put(player,statistics);
	}
	
}
class SelectionCommitee{
	public ArrayList<StaticManager> staticManager;
	SelectionCommitee(){
		this.staticManager=new ArrayList<>();
	}
	
	public Set<Player> SelectedBatsmen(Player player){
		HashSet<Player> sb1=new HashSet<>();
			sb1.add(player);
		return sb1;
		
	}
	public Set<Player> SelectedBowlermen(Player player){
		HashSet<Player> sb2=new HashSet<>();
			sb2.add(player);
		return (sb2);
		
	}
	
}
class PracticeExam3{
	public static void main(String[] args){
		Player player1=new Player("Sachin",40,"Maharastra");
		Player player2=new Player("Virat",35,"Delhi");
		Player player3=new Player("Amit",30,"Gujarat");
		Statistics statistics1=new Statistics(300,15000);
		Statistics statistics2=new Statistics(250,12000);
		Statistics statistics3=new Statistics(45,2000);
		StaticManager batsMan=new StaticManager();
			batsMan.addBaters(player1,statistics1);
			batsMan.addBaters(player2,statistics2);
			batsMan.addBaters(player3,statistics3);

			
		
		Player player6=new Player("Ajit",25,"Delhi");
		Player player7=new Player("Amar",29,"Delhi");
		Player player8=new Player("Rohit",22,"Up");
		
		Statistics statistics6=new Statistics(100,100);
		Statistics statistics7=new Statistics(120,150);
		Statistics statistics8=new Statistics(100,130);
		StaticManager bowlerMan=new StaticManager();
			bowlerMan.addBowlers(player6,statistics6);
			bowlerMan.addBowlers(player7,statistics7);
			bowlerMan.addBowlers(player8,statistics8);

		SelectionCommitee sc=new SelectionCommitee();
		for(Player player:batsMan.getBatsMan().keySet()){
			if (player.getAge()>30){
				System.out.println(player.getName()+","+player.getAge());
			}
		}
		for(Player player:batsMan.getBowlerMan().keySet()){
			if (player.getAge()>30){
				sc.SelectedBowlermen(player);
			}
		}
		
		
		
	}
}

















