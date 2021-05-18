package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Offer;
import app.preciojusto.products.entities.OfferPercentage;
import app.preciojusto.products.entities.OfferUnit;
import app.preciojusto.products.entities.OfferUnitPercentage;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.BadRequestException;
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
        return this.offerService.findOfferById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.OFFER_NOT_FOUND_ERROR));
    }

    @PostMapping("/offerpercentage/add")
    public Offer postAddOfferPercentage(@RequestBody OfferPercentage request) {
        if (request.getOffeid() != null || request.getOfpepercentage() == null || request.getOfpepreviousprice() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferPercentage(request);
    }

    @PostMapping("/offerunit/add")
    public Offer postAddOfferUnit(@RequestBody OfferUnit request) {
        if (request.getOffeid() != null || request.getOfunfirst() == null || request.getOfunsecond() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnit(request);
    }

    @PostMapping("/offerunitpercentage/add")
    public Offer postAddOfferUnitPercentage(@RequestBody OfferUnitPercentage request) {
        if (request.getOffeid() != null || request.getOfuppercentage() == null || request.getOfupunitaffected() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnitPercentage(request);
    }

    @PutMapping("/offerpercentage/update")
    public Offer putUpdateOfferPercentage(@RequestBody OfferPercentage request) {
        if (request.getOffeid() == null || request.getOfpepercentage() == null || request.getOfpepreviousprice() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferPercentage(request);
    }

    @PutMapping("/offerunit/update")
    public Offer putUpdateOfferUnit(@RequestBody OfferUnit request) {
        if (request.getOffeid() == null || request.getOfunfirst() == null || request.getOfunsecond() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnit(request);
    }

    @PutMapping("/offerunitpercentage/update")
    public Offer putUpdateOfferUnitPercentage(@RequestBody OfferUnitPercentage request) {
        if (request.getOffeid() == null || request.getOfuppercentage() == null || request.getOfupunitaffected() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnitPercentage(request);
    }

    @DeleteMapping("/offer/{id}/delete")
    public Boolean deleteOffer(@PathVariable Long id) {
        return this.offerService.delete(id);
    }
}
