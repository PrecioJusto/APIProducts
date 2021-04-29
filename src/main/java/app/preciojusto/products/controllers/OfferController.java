package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Offer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OfferController {

    @GetMapping("/offer/all")
    public List<Offer> getOffers(){
        return null;
    }

    @GetMapping("/offer/{id}/get")
    public Offer getOffer(@PathVariable Long id){
        return null;
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
