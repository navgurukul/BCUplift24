package org.IndiaTeamSelection;
public class Players {
    private String name;
    private String state;
    private  int age;
    public Players(String name, String state, int age){
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

    public String toString() {
        return "Name:" + name + "," +
                "Age:" + age + "," +
                "State" + state;
    }

}
