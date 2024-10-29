package com.techelevator.locations.controllers;

import com.techelevator.locations.dao.MockLocationDao;
import com.techelevator.locations.models.Location;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController()
public class LocationController {

    MockLocationDao dao = new MockLocationDao(); // creates an instance of MockLocationDao

    @RequestMapping(path = "/locations", method = GET)
    public List<Location> getLocations( //if change is made in return statement the method name would need to be changed public String getLocations()
            @RequestParam(name="name", defaultValue = "")
            String locName,

            @RequestParam(name="zip", defaultValue = "")
            String locZip)
    {
        return dao.getLocations(); // also could use "Get locations for Name:" + locName + ", Zip:" + locZip this will return as a String into client
    }

    @RequestMapping(path = "/locations", method = POST)
    public String createLocation(
            @RequestBody
            Location toCreate) {
        return "Create Location:" + toCreate;
    }

    @RequestMapping(path="/locations/{id}", method = GET)
    Location getLocationById(
            @PathVariable
            int id) {

        return dao.getLocationById(id);
    }

    @RequestMapping(path = "/locations", method = PUT)
    public String updateLocation(Location toUpdate) {
        return "Future home of Update Location" + toUpdate;
    }

    @RequestMapping(method = DELETE, path = "/locations/{locationId}")
    public String deleteLocation(
            @PathVariable
            int locationId) {
        return "Future home of Delete Location. Delete id= " + locationId;
    }

    @RequestMapping(path="/locations/{id}/gates/{gateId}")
    public String getGateForLocation(
            @PathVariable
            int id,

            @PathVariable
            int gateId) {
        return "Future home of Get Location gate. Location:" + id + ", Gate: " + gateId;
    }
}

