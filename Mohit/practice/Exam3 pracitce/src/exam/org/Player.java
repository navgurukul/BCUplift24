package exam.org;

public class Player implements Comparable<Player>{
    private String name;
    private Statistics statics;
    private String playerRole;

    public Player(String name, int age,String state,Statistics statics,String playerRole) {
        this.name = name;
        this.state = state;
        this.age = age;
        this.statics=statics;
        this.playerRole=playerRole;
    }

    public Statistics getStatics() {
        return statics;
    }

    private String state;
    private int age;


    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public int getAge() {
        return age;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age + '\''+
                ", runs=" + statics.getNumber() + '\''+
                ", number of matches=" + statics.getNumberOfMatches() + '\''+
                ", Average=" + statics.calculateAvg() + '\''+
                ", Player role=" + playerRole + '\''+

                '}';
    }

    @Override
    public int compareTo(Player player) {
        Double compareAvg=statics.calculateAvg();
        Double comparePlayer=player.statics.calculateAvg();
        int diff=compareAvg.compareTo(comparePlayer);
        if (diff==0){
            return name.compareTo(player.name);
        }
        return -diff;
    }
}
