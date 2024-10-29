package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.exception.DaoException;
import com.techelevator.auctions.model.Auction;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auctions")
@PreAuthorize("isAuthenticated()")  // Require authentication for all methods at the class level ensures that all methods
// in the class require authentication.
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

/*Step Four: Add authentication to controller methods
In the server project, open AuctionController.java. All methods must require authentication except list(), the method that responds to /auctions. See if you can accomplish this by only adding two lines to the class.

After you complete this step, the step4_AllMethods_ExpectUnauthorized and step4_list_ExpectOk tests in AuctionControllerTests pass.*/
    @RequestMapping(path = "", method = RequestMethod.GET)
    @PreAuthorize("permitAll")  // Allow unauthenticated access to this method above the list() method allows it to be
    // accessed without authentication, making an exception to the class-level rule.
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0")
        double currentBid_lte) {

        if (!title_like.equals("")) {
            return auctionDao.getAuctionsByTitle(title_like);
        }
        if (currentBid_lte > 0) {
            return auctionDao.getAuctionsByMaxBid(currentBid_lte);
        }

        return auctionDao.getAuctions();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        Auction auction = auctionDao.getAuctionById(id);
        if (auction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        } else {
            return auction;
        }
    }

    @PreAuthorize("hasAnyRole('CREATOR', 'ADMIN')")  // Allow CREATOR and ADMIN roles
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction create(@Valid @RequestBody Auction auction) {
        return auctionDao.createAuction(auction);
    }

    @PreAuthorize("hasAnyRole('CREATOR', 'ADMIN')")  // Allow CREATOR and ADMIN roles
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Auction update(@Valid @RequestBody Auction auction, @PathVariable int id) {
        auction.setId(id);
        try {
            return auctionDao.updateAuction(auction);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction Not Found");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")  // Allow only ADMIN role
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        auctionDao.deleteAuctionById(id);
    }

    @RequestMapping(path = "/whoami", method = RequestMethod.GET)
    public String whoAmI() {
        // Get the current authenticated user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();  // Return the username
    }

}
