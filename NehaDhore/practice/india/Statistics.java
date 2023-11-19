package india;

import java.util.HashMap;

class Statistics implements Player {
     private String  name;
     private int age;
     private String state;

     private  double numberOfMatches ;
     private double numberOfRuns;

//     Statistics() {
//        myMap = new HashMap<>();
//    }


    void Player(String name, int age, String state,  double numbersOfMatches, double numbersOfRun){
         this.name = name;
         this.age = age;
         this.state = state;
         this.numberOfMatches = numbersOfMatches;
         this.numberOfRuns = numbersOfRun;
     }

     public String getName() {
         return name;
     }

     public int getAge() {
         return age;
     }
     public String getState(){
         return state;
     }

     public double getNumberOfMatches() {
         return numberOfMatches;
     }

     public double getNumberOfRuns() {
         return numberOfRuns;
     }

     Map <Player ,Statistics> myMap;

     public double  calculateAvg(){

          return numberOfRuns/numberOfMatches;
          myMap.put(calculateAvg());

     }

     @Override
     public String toString() {

             return  "Name = " + name+
             "Age = " + age+
             "State = " + state;

     }
 }
