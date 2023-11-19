package org.uplift.IndianTeamSelection;

public class Player {
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

    public String  getState(){
        return state;
    }

    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append("Name: "+name);
        str.append(" Age: "+age);
        str.append(" State: "+state);
        String res=str.toString();
        return res;
    }
}
