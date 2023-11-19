package PracticeExam;

public class Bowler implements Player{
    private String name;
    private int age;
    private String state;

    public Bowler(String name, int age, String state) {
        this.name = name;
        this.age = age;
        this.state = state;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getState() {
        return state;
    }
}
