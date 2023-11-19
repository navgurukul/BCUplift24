import java.util.HashMap;
import java.util.Map;

public class Players {
    private String name;
    private String age;
    private String state;


    Players(String name,String age,String state){
        this.name= name;
        this.age=age;
        this.state= state;

    }
    public String getName(){
        return name;
    }
    public String getAge(){
        return age;
    }
    public String getState(){
        return state;
    }
    //Map<Players,Statistics >batsmansmap= new HashMap<>();

   // Map<Players, Statistics> bowlersmap = new HashMap<>();

}
