package com.techelevator.locations.dao;

import com.techelevator.locations.models.Location;

import java.util.List;

public class MockExtendedLocationDao extends MockLocationDao {

    @Override
    protected void buildLocations() {
        locations.add(new Location(1,
                "Extended Baker Electric Building",
                "7100 Euclid Ave",
                "Cleveland",
                "OH",
                "44103", new String[]{"Gate A", "Gate B"}));

        locations.add(new Location(2,
                "Extended Rev1 Ventures",
                "1275 Kinnear Rd",
                "Columbus",
                "OH",
                "43212", new String[]{"Gate I", "Gate II"}));
        locations.add(new Location(3,
                "Extended HCDC Business Center",
                "1776 Mentor Ave",
                "Cincinnati",
                "OH",
                "45212", new String[]{"Alpha", "Bravo", "Charlie"}));
    }
}
