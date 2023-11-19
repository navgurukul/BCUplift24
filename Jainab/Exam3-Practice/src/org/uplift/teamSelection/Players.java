package org.uplift.teamSelection;

public class Players {
    private String name;
    private String stateName;
    private int age;
    public Players(String name, String stateName, int age){
        this.name=name;
        this.age=age;
        this.stateName=stateName;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge(){
        return age;
    }
    public String getStateName(){
        return stateName;
    }
}
