//import SelctionCommition.Selectioncommity;
import org.IndianTeamSelection.SelectionCommittee;
import org.IndianTeamSelection.StatsManager;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        StatsManager statsManager = new StatsManager();
        SelectionCommittee committee = new SelectionCommittee();

        committee.selectPlayers(statsManager);
        }
    }
