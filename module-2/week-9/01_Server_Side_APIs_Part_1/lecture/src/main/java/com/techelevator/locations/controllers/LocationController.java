package com.techelevator.locations.controllers;

import com.techelevator.locations.models.Location;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    @RequestMapping(path = "/locations", method = RequestMethod.GET)
    public String getLocations(
            @RequestParam(value = "name", defaultValue = "****")
            String name,

            @RequestParam(value = "zip", defaultValue = "$$$$")
            String zip,

            @RequestParam(value = "date", defaultValue = "@@@@")
            String date

            )
    {
        return "Future home of List of locations. Name:" + name + ", Zip:" + zip + ", Date:" + date;
    }


    @RequestMapping(path = "/locations", method = RequestMethod.POST)
    public String createLocation(
            @RequestBody
            Location toCreate) {

        return "Create Location:" + toCreate;
    }

    @RequestMapping(method = RequestMethod.GET, path="/locations/{id}")
    String getLocationById(@PathVariable int id,

                           @RequestParam(value = "name", defaultValue = "****")
                           String name,

                           @RequestParam(value = "zip", defaultValue = "$$$$")
                           String zip,

                           @RequestParam(value = "date", defaultValue = "@@@@")
                           String date) {

        return "Future home of get Location by Id " + id + ",Name:" + name + ", Zip:" + zip + ", Date:" + date;
    }

    @RequestMapping(path = "/locations", method = RequestMethod.PUT)
    public String updateLocation(
            @RequestBody
            Location toUpdate) {

        return "Future home of Update Location" + toUpdate;
    }

    @RequestMapping(path = "/locations/{id}", method = RequestMethod.DELETE)
    public String deleteLocation(@PathVariable int id) {

        return "Future home of Delete Location. Delete id= " + id;
    }

    @RequestMapping(path = "/locations/{id}/gates/{gateId}", method = RequestMethod.GET)
    public String getGateForLocation(@PathVariable int id, @PathVariable int gateId) {

        return "Future home of Get Location gate. Location:" + id + ", Gate: " + gateId;
    }


}
