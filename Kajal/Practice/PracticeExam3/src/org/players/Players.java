package org.players;

import org.statistics.CricketSelectionComittee;

public class Players{
    private String name;
    private int age;
    private String state;

    public Players(String name, int age, String state){
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
        sb.append("name='" + name );
        sb.append(", age=" + age );
        sb.append(", state='" + state);
        return sb.toString();
    }
}
