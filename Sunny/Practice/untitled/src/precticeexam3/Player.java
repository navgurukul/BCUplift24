package precticeexam3;

import java.util.*;

class Player implements Comparable<Player> {
    private String name;
    private int age;
    private String state;

    public String getState() {
        return state;
    }

    public int getAge() {
        return age;
    }

    Player(String name, int age, String state){
        this.name = name;
        this.age = age;
        this.state = state;
    }



    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Player name : ");
        sb.append(name);
        sb.append(" age : ");
        sb.append(age);
        sb.append(" from ");
        sb.append(state);
        return sb.toString();
    }

    public int compareTo(Player object){
        return this.name.compareTo(object.name);
    }


}
