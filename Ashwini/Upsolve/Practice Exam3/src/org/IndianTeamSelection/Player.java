package org.IndianTeamSelection;

public class Player {
    private String name;
    private int age;
    private String state;
    public Player(String name,int age,String state){
        this.name = name;
        this.age = age;
        this.state = state;
    }
    public int getAge(){
        return age;
    }
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", state=" + state +
                '}';
    }

    public String getState() {
        return state;
    }
}
