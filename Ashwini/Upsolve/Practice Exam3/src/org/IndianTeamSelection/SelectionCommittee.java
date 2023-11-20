package org.IndianTeamSelection;

import org.IndianTeamSelection.statisties.BatsmanStatistics;
import org.IndianTeamSelection.statisties.BowlerStatistics;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import java.util.*;

public class SelectionCommittee {
    public void selectPlayers(StatsManager statsManager) {
        Map<Player, BatsmanStatistics> batsmanMap = statsManager.getBatsmanMap();
        Map<Player, BowlerStatistics> bowlerMap = statsManager.getBowlerMap();

        TreeSet<Map.Entry<Player, BatsmanStatistics>> eligibleBatsmen = selectTopNBatsmen(batsmanMap, 3);
        TreeSet<Map.Entry<Player, BowlerStatistics>> eligibleBowlers = selectTopNBowlers(bowlerMap, 2);

        Set<Player> selectedPlayers = new HashSet<>();
        Set<Player> selectedBatsmen = new HashSet<>();
        Set<Player> selectedBowlers = new HashSet<>();

        for (Map.Entry<Player, BatsmanStatistics> entry : eligibleBatsmen) {
            Player batsman = entry.getKey();
            if (isStateUnique(selectedPlayers, batsman)) {
                selectedPlayers.add(batsman);
                selectedBatsmen.add(batsman);
            }
        }

        for (Map.Entry<Player, BowlerStatistics> entry : eligibleBowlers) {
            Player bowler = entry.getKey();
            if (isStateUnique(selectedPlayers, bowler)) {
                selectedPlayers.add(bowler);
                selectedBowlers.add(bowler);
            }
        }

        System.out.println("Selected Batsmen: " + selectedBatsmen);
        System.out.println("Selected Bowlers: " + selectedBowlers);
    }


    public TreeSet<Map.Entry<Player, BatsmanStatistics>> selectTopNBatsmen(Map<Player, BatsmanStatistics> map, int n) {
        TreeSet<Map.Entry<Player, BatsmanStatistics>> topPlayers = new TreeSet<>((e1, e2) ->
                Double.compare(e2.getValue().calculateAverage(), e1.getValue().calculateAverage()));

        for (Map.Entry<Player, BatsmanStatistics> entry : map.entrySet()) {
            topPlayers.add(entry);
        }

        TreeSet<Map.Entry<Player, BatsmanStatistics>> result = new TreeSet<>(Comparator.comparingInt(e -> e.getKey().getAge()));
        for (Map.Entry<Player, BatsmanStatistics> entry : topPlayers) {
            result.add(entry);
            if (result.size() > n) {
                result.pollLast();
            }
        }

        return result;
    }

    public TreeSet<Map.Entry<Player, BowlerStatistics>> selectTopNBowlers(Map<Player, BowlerStatistics> map, int n) {
        TreeSet<Map.Entry<Player, BowlerStatistics>> topPlayers = new TreeSet<>((e1, e2) ->
                Double.compare(e2.getValue().calculateAverage(), e1.getValue().calculateAverage()));

        for (Map.Entry<Player, BowlerStatistics> entry : map.entrySet()) {
            topPlayers.add(entry);
        }

        TreeSet<Map.Entry<Player, BowlerStatistics>> result = new TreeSet<>(Comparator.comparingInt(e -> e.getKey().getAge()));
        for (Map.Entry<Player, BowlerStatistics> entry : topPlayers) {
            result.add(entry);
            if (result.size() > n) {
                result.pollLast();
            }
        }

        return result;
    }
    public boolean isStateUnique(Set<Player> selectedPlayers, Player player) {
        for (Player p : selectedPlayers) {
            if (p.getState().equals(player.getState())) {
                return false;
            }
        }
        return true;
    }
}
