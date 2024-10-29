package com.techelevator.auctions.controller;

import com.techelevator.auctions.model.Auction;
import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @GetMapping
    public List<Auction> list(
            @RequestParam(defaultValue = "") String title_like,
            @RequestParam(defaultValue = "0") double currentBid_lte) {

        if (!title_like.isEmpty() && currentBid_lte > 0) {
            return auctionDao.getAuctionsByTitleAndMaxBid(title_like, currentBid_lte);
        } else if (!title_like.isEmpty()) {
            return auctionDao.getAuctionsByTitle(title_like);
        } else if (currentBid_lte > 0) {
            return auctionDao.getAuctionsByMaxBid(currentBid_lte);
        } else {
            return auctionDao.getAuctions();
        }
    }

    @GetMapping("/{id}")
    public Auction get(@PathVariable int id) {
        return auctionDao.getAuctionById(id);
    }

    @PostMapping
    public Auction create(@RequestBody Auction auction) {
        return auctionDao.createAuction(auction);
    }
}