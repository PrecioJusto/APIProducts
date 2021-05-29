package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.*;
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

    @GetMapping("/offers")
    public List<Offer> getOffers() {
        return this.offerService.findAll();
    }

    @GetMapping("/offer/{id}/")
    public Offer getOffer(@PathVariable Long id) throws ResourceNotFoundException {
        return this.offerService.findOfferById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.OFFER_NOT_FOUND_ERROR));
    }

    @PostMapping("/offerpercentage")
    public Offer postAddOfferPercentage(@RequestBody OfferPercentage request) {
        if (request.getOffeid() != null || request.getOfpepercentage() == null || request.getOfpepreviousprice() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferPercentage(request);
    }

    @PostMapping("/offerunit")
    public Offer postAddOfferUnit(@RequestBody OfferUnit request) {
        if (request.getOffeid() != null || request.getOfunfirst() == null || request.getOfunsecond() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnit(request);
    }

    @PostMapping("/offerunitpercentage")
    public Offer postAddOfferUnitPercentage(@RequestBody OfferUnitPercentage request) {
        if (request.getOffeid() != null || request.getOfuppercentage() == null || request.getOfupunitaffected() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnitPercentage(request);
    }

    @PostMapping("/offerunknown")
    public Offer postAddOfferUnknown(@RequestBody OfferUnknown request) {
        if (request.getOffeid() != null || request.getOfunname() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnknown(request);
    }

    @PostMapping("/offerunitplainprice")
    public Offer postAddOfferUnitPlainPrice(@RequestBody OfferUnitPlainPrice request) {
        if (request.getOffeid() != null || request.getOfupprice() == null || request.getOfupunits() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnitPlainPrice(request);
    }

    @PutMapping("/offerpercentage")
    public Offer putUpdateOfferPercentage(@RequestBody OfferPercentage request) {
        if (request.getOffeid() == null || request.getOfpepercentage() == null || request.getOfpepreviousprice() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferPercentage(request);
    }

    @PutMapping("/offerunit")
    public Offer putUpdateOfferUnit(@RequestBody OfferUnit request) {
        if (request.getOffeid() == null || request.getOfunfirst() == null || request.getOfunsecond() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnit(request);
    }

    @PutMapping("/offerunitpercentage")
    public Offer putUpdateOfferUnitPercentage(@RequestBody OfferUnitPercentage request) {
        if (request.getOffeid() == null || request.getOfuppercentage() == null || request.getOfupunitaffected() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnitPercentage(request);
    }

    @PutMapping("/offerunknown")
    public Offer putAddOfferUnknown(@RequestBody OfferUnknown request) {
        if (request.getOffeid() == null || request.getOfunname() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnknown(request);
    }

    @PutMapping("/offerunitplainprice")
    public Offer putAddOfferUnitPlainPrice(@RequestBody OfferUnitPlainPrice request) {
        if (request.getOffeid() == null || request.getOfupprice() == null || request.getOfupunits() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.offerService.saveOfferUnitPlainPrice(request);
    }

    @DeleteMapping("/offer/{id}")
    public Boolean deleteOffer(@PathVariable Long id) {
        return this.offerService.delete(id);
    }
}
