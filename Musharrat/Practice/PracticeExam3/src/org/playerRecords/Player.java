package org.playerRecords;

public class Player implements Comparable<Player>{
    private String name;
    private int age;
    private String state;


    public Player(String name, int age, String state){
        this.name = name;
        this.age = age;
        this.state = state;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(name);
        sb.append(" Age: ");
        sb.append(age);
        sb.append(" State: ");
        sb.append(state);
        return sb.toString();
    }

    @Override
    public int compareTo(Player o) {
        return -1;
    }
}
