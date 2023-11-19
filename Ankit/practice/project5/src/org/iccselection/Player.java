package org.iccselection;

public class Player{
    private String name;
    private int age ;
    private String state ;

    public Player(String name, int age, String state){
        this.name = name ;
        this.age = age ;
        this.state = state ;
    }

    public String getName(){
        return name ;
    }
    public String getState(){
        return state ;
    }
    public int getAge(){
        return age ;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("NAME; ") ;
        sb.append(getName()) ;
        sb.append(" ") ;
        sb.append("AGE: ") ;
        sb.append(" ") ;
        sb.append(getAge()) ;
        sb.append("STATE; ") ;
        sb.append(getState()) ;
        return sb.toString() ;
    }



}
