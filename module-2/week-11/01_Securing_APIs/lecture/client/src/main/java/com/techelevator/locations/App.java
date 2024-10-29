package com.techelevator.locations;

import com.techelevator.locations.model.Location;
import com.techelevator.locations.services.AuthenticationService;
import com.techelevator.locations.services.LocationService;

public class App {

    private final LocationService locationService = new LocationService();
    private final AuthenticationService authenticationService = new AuthenticationService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {

        String token = login("admin", "password");
        locationService.setAuthToken(token);

        Location[] locations = locationService.getAll();

        Location location = locationService.getOne(locations[0].getId());

        String tax = locationService.getOneTax(locations[0].getId());

        Location locationEnteredByUser = new Location("Tech Elevator", "123 Main Str", "Cincinnati", "OH", "45220");

        Location locationFromApi = locationService.add(locationEnteredByUser);
        boolean deleted = locationService.delete(locationFromApi.getId());
    }

    private String login(String username, String password) {

        String token = authenticationService.login(username, password);
        if (token != null) {
            System.out.println("Received token: " + token );
            return token;
        } else {
            System.out.println("Failed to get token!");
            return null;
        }
    }
}
