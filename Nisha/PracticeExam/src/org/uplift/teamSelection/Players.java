package org.uplift.teamSelection;

public class Players {
    String name;
    int age;
    String state;
    public Players(String name,int age,String state){
        this.name=name;
        this.age=age;
        this.state=state;
    }

    public String getName() {
        return name;
    }

    public static int getAge() {
        return age;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder("Player Name: "+ getName());
        sb.append("\n Player age: "+getAge());
        sb.append("\n Player State: "+getState());
        return sb.toString();
    }
}
