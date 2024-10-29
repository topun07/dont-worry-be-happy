package com.techelevator.locations.dao;

import com.techelevator.locations.models.Location;

import java.util.ArrayList;
import java.util.List;

public class MockLocationDao {

    private List<Location> locations = new ArrayList<>();

    String[] t = new String[5];

    public List<Location> getLocations() {
        return locations;
    }

    public MockLocationDao() {
        buildLocations();
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public Location getLocationById(int id) {
        for (Location location : locations) {
            if (location.getId() == id) {
                return location;
            }
        }
        return null;
    }

    public List<Location> filterLocationsByName(String name) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations) {
            if (location.getName().equalsIgnoreCase(name)) {
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
    }

    public List<Location> filterLocationsByZip(String zip) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations) {
            if (location.getZip().equalsIgnoreCase(zip)) {
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
    }

    public List<Location> filterLocationsByNameAndZip(String name, String zip) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations) {
            if (location.getName().equalsIgnoreCase(name) && location.getZip().equalsIgnoreCase(zip)) {
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
    }

    public boolean deleteLocation(int id) {
        Location toDelete = getLocationById(id);

        if(toDelete == null)
            return false;
        else
            locations.remove(toDelete);

        return true;
    }

    private void buildLocations() {
        locations.add(new Location(1,
                "Baker Electric Building",
                "7100 Euclid Ave",
                "Cleveland",
                "OH",
                "44103", new String[]{"Gate A", "Gate B"}));

        locations.add(new Location(2,
                "Rev1 Ventures",
                "1275 Kinnear Rd",
                "Columbus",
                "OH",
                "43212", new String[]{"Gate I", "Gate II"}));
        locations.add(new Location(3,
                "HCDC Business Center",
                "1776 Mentor Ave",
                "Cincinnati",
                "OH",
                "45212", new String[]{"Alpha", "Bravo", "Charlie"}));
        locations.add(new Location(4,
                "House of Metal",
                "901 Pennsylvania Ave",
                "Pittsburgh",
                "PA",
                "15233", new String[]{"1", "2"}));
        locations.add(new Location(5,
                "TechTown Detroit",
                "440 Burroughs St",
                "Detroit",
                "MI",
                "48202", new String[]{"Block A", "Block B"}));
        locations.add(new Location(6,
                "Duane Morris Plaza",
                "30 S 17th St",
                "Philadelphia",
                "PA",
                "19103", new String[]{"Gate A1", "Gate B1"}));
    }
}
