package org.worldCupselection;


public class Player {
    private final String name;
    private final int age;

    private final String state;

    Player(String name, int age, String state){
        this.name=name;
        this.age=age;
        this.state=state;
    }

    public String getName(){
        return name;
    }

    public String getState(){
        return state;
    }

    public int getAge(){
        return age;
    }

    public  String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name of the player:"+name);
        return String.valueOf(sb);
    }

}
