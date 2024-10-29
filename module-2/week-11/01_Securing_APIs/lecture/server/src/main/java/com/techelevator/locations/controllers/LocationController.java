package com.techelevator.locations.controllers;

import com.techelevator.locations.dao.LocationDao;
import com.techelevator.locations.dao.MockLocationDao;
import com.techelevator.locations.models.Location;
import com.techelevator.locations.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;


/*
@PreAuthorize("isAuthenticated()"): // The user must be authenticated.
@PreAuthorize("permitAll"):  //The user doesn't have to be authenticated.
@PreAuthorize("hasRole('ADMIN')"):  //The user must be authenticated and have the role ADMIN.
@PreAuthorize("hasAnyRole('ADMIN', 'USER')"):  //The user must be authenticated and have either the ADMIN or USER role.
*/


@PreAuthorize("isAuthenticated()")// The user must be authenticated.
@RestController
public class LocationController {

    //@Autowired
    LocationDao dao;

    //@Autowired
    TaxService taxService;

    @Autowired
    public LocationController(LocationDao dao, TaxService taxService) {
        this.dao = dao;
        this.taxService = taxService;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/locations/{id}", method = RequestMethod.PUT)
    public Location updateLocation(@RequestBody Location location, @PathVariable int id) {

        System.out.println("REST API -> Update location with id:" + id);

        Location l = dao.getLocationById(id);

        if (l != null) {
            l.setZip(location.getZip());
            l.setAddress(location.getAddress());
            l.setCity(location.getCity());
            l.setName(location.getName());
            l.setState(location.getState());
            l.setGates(location.getGates());
        }

        return l;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/locations", method = RequestMethod.POST)
    public Location addLocation(@Valid @RequestBody Location location, Principal principal) {

        System.out.println("REST API -> Create Location");

        if (location != null) {

            dao.addLocation(location);
            return location;
        }
        return null;
    }

    @RequestMapping(path = "/locations/{id}", method = RequestMethod.GET)
    public Location get(@PathVariable int id) {

        System.out.println("REST API -> Get a single location with id:" + id);

        Location l = dao.getLocationById(id);

        if (l != null)
            return l;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location " + id + " does not exist");
    }

    @RequestMapping(path = "/locations/{id}/gates/{gateId}", method = RequestMethod.GET)
    public String get(@PathVariable int id, @PathVariable int gateId) {

        System.out.println("REST API -> Get a the name of gate " + gateId + " for location " + id);

        Location found = dao.getLocationById(id);
        if (found != null)
            return found.getGates()[gateId];
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such location");
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/locations/{id}", method = RequestMethod.DELETE)
    public void deleteLocation(@PathVariable int id, Principal principal) {

        System.out.println("REST API -> Delete location with id:" + id);

        if("admin".equals(principal.getName())) {
            System.out.println("Deleted by Admin");
            dao.deleteLocation(id);
        }
        else
        {
            if(id < 1000) {
                System.out.println("Delete by User");
                dao.deleteLocation(id);
            }
        }


    }

    @PreAuthorize("permitAll")  //The user doesn't have to be authenticated.
    @RequestMapping(path = "/locations", method = RequestMethod.GET)
    public List<Location> list(@RequestParam(value = "name_like", defaultValue = "") String name,
                               @RequestParam(value = "zip", defaultValue = "") String zip) {

        System.out.println("REST API -> Get all locations");


        if (name.isEmpty() && zip.isEmpty())
            return dao.getLocations();
        else if (!name.isEmpty() && !zip.isEmpty())
            return dao.filterLocationsByNameAndZip(name, zip);
        else if (name.isEmpty())
            return dao.filterLocationsByZip(zip);
        else
            return dao.filterLocationsByName(name);
    }

    @RequestMapping(path = "/locations/{id}/tax", method = RequestMethod.GET)
    public BigDecimal getLocationTaxRate(@PathVariable int id) {

        Location l = dao.getLocationById(id);
        if(l == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location " + id + " does not exist!");

        return taxService.getTaxRate(l.getState());
    }
}

