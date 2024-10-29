package com.techelevator.auctions.controller;

import java.util.List;

import com.techelevator.auctions.exception.DaoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController(AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte) {

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
            return auctionDao.getAuctionById(id);
        }
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Auction create(@RequestBody @Valid Auction auction) {
        return auctionDao.createAuction(auction);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Auction update(@PathVariable int id, @RequestBody @Valid Auction auction) {
        auction.setId(id);

        try {
            return auctionDao.updateAuction(auction);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction ID not found");
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)  // Responds with 204 No Content
    public void delete(@PathVariable int id) {
        try {
            auctionDao.deleteAuctionById(id);
        } catch (DaoException e) {
            // If the auction ID isn't valid, throw a 404 Not Found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction ID not found");

            /*  Step Six: Implement the delete() method
This method deletes a specific auction.

In AuctionController.Java, create a method named delete() that accepts an int and returns void.
Then add the @RequestMapping annotation to the method so it responds to DELETE requests for /auctions with a number
following it. Next, pass a value to the path to tell it to accept a dynamic parameter.

This method must also:

Call the DAO method that deletes an auction, passing to it the ID parameter.
Respond with a 204(No Content) status code back to the client, as the method doesn't return a value.
If completed properly, the delete_ShouldReturnNoContent test passes. */

        }
    }
}
