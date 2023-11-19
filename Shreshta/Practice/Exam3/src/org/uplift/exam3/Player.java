package org.uplift.exam3;

public class Player {
        private String name;
        private int age;
        private String state;

    public Player(String name, int age, String state) {
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

    public String toString(){
        StringBuilder playerDetails = new StringBuilder();
        playerDetails.append(name);
        playerDetails.append(age);
        playerDetails.append(state);
        return playerDetails.toString();
    }
}
