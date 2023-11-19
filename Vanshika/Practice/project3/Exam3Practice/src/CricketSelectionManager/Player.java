package CricketSelectionManager;

public class Player{
    private String name;
    private int age;
    private String state;

    public Player(String name, int age, String state){
        this.name = name;
        this.age = age;
        this.state = state;
    }

    public String toString(){
        return name + state;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getState() {
        return state;
    }
    StatsManager s1 = new StatsManager();

}
