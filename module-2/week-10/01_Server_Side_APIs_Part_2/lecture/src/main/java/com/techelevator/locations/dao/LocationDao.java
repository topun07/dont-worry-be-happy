package com.techelevator.locations.dao;

import com.techelevator.locations.models.Location;

import java.util.List;

public interface LocationDao {
    List<Location> getLocations();

    void addLocation(Location location);

    Location getLocationById(int id);

    List<Location> filterLocationsByName(String name);

    List<Location> filterLocationsByZip(String zip);

    List<Location> filterLocationsByNameAndZip(String name, String zip);

    boolean deleteLocation(int id);
}
