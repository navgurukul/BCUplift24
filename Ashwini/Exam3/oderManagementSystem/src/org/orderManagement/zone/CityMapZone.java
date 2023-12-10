package org.orderManagement.zone;

import java.util.HashMap;
import java.util.Map;

import static org.orderManagement.zone.Zone.*;

public class CityMapZone {
    private Map<String, Zone> cityMapZone = new HashMap<>();

    public CityMapZone(){
        cityMapZone.put("Chennai", Zone.SOUTH);
        cityMapZone.put("Bangalore", Zone.SOUTH);

        cityMapZone.put("Mumbai", Zone.WEST);
        cityMapZone.put( "goa", Zone.WEST);


        cityMapZone.put("Kolkatta", Zone.EAST);
        cityMapZone.put("Bhuvaneshwar", Zone.EAST);


        cityMapZone.put("DElhi", Zone.NORTH);
        cityMapZone.put("Noida", Zone.NORTH);




    }
}
