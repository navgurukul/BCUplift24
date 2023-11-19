package org;

public class Player {
    private String name;
    private int age;
    private String state;

    public Player(String name, int age, String state){
        this.name=name;
        this.age=age;
        this.state=state;

    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String getState(){
        return state;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Name: "+name);
        sb.append("age: " +age);
        sb.append("state: "+state);
        return sb.toString();

    }

}
