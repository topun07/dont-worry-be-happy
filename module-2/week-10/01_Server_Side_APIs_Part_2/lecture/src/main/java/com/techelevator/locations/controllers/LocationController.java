package com.techelevator.locations.controllers;

import com.techelevator.locations.dao.LocationDao;
import com.techelevator.locations.dao.MockExtendedLocationDao;
import com.techelevator.locations.dao.MockLocationDao;
import com.techelevator.locations.models.Location;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LocationController {

    LocationDao dao;

    public LocationController() {
        this.dao = new MockLocationDao();
        //this.dao = new MockExtendedLocationDao();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/locations/{id}", method = RequestMethod.PUT)
    public void updateLocation(@Valid @RequestBody Location location, @PathVariable int id) {
        Location l = dao.getLocationById(id);

        if (l != null) {
            l.setZip(location.getZip());
            l.setAddress(location.getAddress());
            l.setCity(location.getCity());
            l.setName(location.getName());
            l.setState(location.getState());
            l.setGates(location.getGates());
        }
    }

    @RequestMapping(path = "/locations", method = RequestMethod.POST)
    public Location addLocation(@Valid @RequestBody Location location) {
        if (location != null) {
            dao.addLocation(location);
            return location;
        }
        return null;
    }

    @RequestMapping(path = "/locations/{id}", method = RequestMethod.GET)
    public Location get(@PathVariable int id) {

        Location l = dao.getLocationById(id);

        if (l != null)
            return l;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location " + id + " does not exist");
    }

    @RequestMapping(path = "/locations/{id}/gates/{gateId}", method = RequestMethod.GET)
    public String get(@PathVariable int id, @PathVariable int gateId) {

        Location found = dao.getLocationById(id);

        if (found != null)
            try {
                return found.getGates()[gateId];
            } catch (Exception ex) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gate " + gateId + " does not exist");
            }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location " + id + " does not exist");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/locations/{id}", method = RequestMethod.DELETE)
    public void deleteLocation(@PathVariable int id) {
        dao.deleteLocation(id);
    }

    @RequestMapping(path = "/locations", method = RequestMethod.GET)
    public List<Location> list(@RequestParam(value = "name_like", defaultValue = "") String name,
                               @RequestParam(value = "zip", defaultValue = "") String zip) {

        if (name.isEmpty() && zip.isEmpty())
            return dao.getLocations();
        else if (!name.isEmpty() && !zip.isEmpty())
            return dao.filterLocationsByNameAndZip(name, zip);
        else if (name.isEmpty())
            return dao.filterLocationsByZip(zip);
        else
            return dao.filterLocationsByName(name);
    }
}

