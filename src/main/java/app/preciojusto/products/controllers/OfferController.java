package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/offer/all")
    public List<Offer> getOffers() {
        return this.offerService.findAll();
    }

    @GetMapping("/offer/{id}/get")
    public Offer getOffer(@PathVariable Long id) throws ResourceNotFoundException {
        return this.offerService.findById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.OFFER_NOT_FOUND_ERROR));
    }

    @PostMapping("/offer/add")
    public Offer postAddOffer(@RequestBody String payload) {
        return null;
    }

    @PutMapping("/offer/{id}/update")
    public Offer putUpdateOffer(@PathVariable Long id, @RequestBody String payload) {
        return null;
    }

    @DeleteMapping("/offer/{id}/delete")
    public Boolean deleteOffer(@RequestBody String payload) {
        return false;
    }
}
