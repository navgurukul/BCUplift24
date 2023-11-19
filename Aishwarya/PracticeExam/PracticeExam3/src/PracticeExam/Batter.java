package PracticeExam;

public class Batter implements Player{
    private String name;
    private int age;
    private String state;

    public Batter(String name, int age, String state) {
        this.name = name;
        this.age = age;
        this.state = state;
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

    public String toString(){
        return getName() + " " + getAge() + " " + getState();
    }
}
