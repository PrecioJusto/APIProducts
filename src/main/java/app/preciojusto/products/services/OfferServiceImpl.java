package app.preciojusto.products.services;

import app.preciojusto.products.entities.*;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    public OfferPercentageRepository offerPercentageRepository;

    @Autowired
    public OfferUnitRepository offerUnitRepository;

    @Autowired
    public OfferUnitPercentageRepository offerUnitPercentageRepository;

    @Autowired
    public OfferUnknownRepository offerUnknownRepository;


    @Override
    public Optional<Offer> findOfferById(Long id) {
        return this.offerRepository.findById(id);
    }


    @Override
    public List<Offer> findAll() {
        return this.offerRepository.findAll();
    }

    @Override
    public Offer saveOfferUnitPercentage(OfferUnitPercentage request) {
        OfferUnitPercentage offerUnitPercentage;
        if (request.getOffeid() != null) {
            offerUnitPercentage = this.offerUnitPercentageRepository.findOfferByOffeid(request.getOffeid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.OFFERUNITPERCENTAGE_NOT_FOUND_ERROR));
            offerUnitPercentage.setOfuppercentage(request.getOfuppercentage());
            offerUnitPercentage.setOfupunitaffected(request.getOfupunitaffected());
        } else offerUnitPercentage = request;
        try {
            return this.offerRepository.save(offerUnitPercentage);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.OFFERUNITPERCENTAGE_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Offer saveOfferPercentage(OfferPercentage request) {
        OfferPercentage offerPercentage;
        if (request.getOffeid() != null) {
            offerPercentage = this.offerPercentageRepository.findOfferByOffeid(request.getOffeid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.OFFERPERCENTAGE_NOT_FOUND_ERROR));
            offerPercentage.setOfpepreviousprice(request.getOfpepreviousprice());
            offerPercentage.setOfpepercentage(request.getOfpepercentage());
        } else offerPercentage = request;
        try {
            return this.offerRepository.save(offerPercentage);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.OFFERPERCENTAGE_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Offer saveOfferUnit(OfferUnit request) {
        OfferUnit offerUnit;
        if (request.getOffeid() != null) {
            offerUnit = this.offerUnitRepository.findOfferByOffeid(request.getOffeid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.OFFERUNIT_NOT_FOUND_ERROR));
            offerUnit.setOfunfirst(request.getOfunfirst());
            offerUnit.setOfunsecond(request.getOfunsecond());
        } else offerUnit = request;
        try {
            return this.offerRepository.save(offerUnit);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.OFFERUNIT_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Offer saveOfferUnknown(OfferUnknown request) {
        OfferUnknown offerUnknown;
        if (request.getOffeid() != null) {
            offerUnknown = this.offerUnknownRepository.findOfferByOffeid(request.getOffeid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.OFFERUNKNOWN_NOT_FOUND_ERROR));
            offerUnknown.setOfunname(request.getOfunname());
        } else offerUnknown = request;
        try {
            return this.offerRepository.save(offerUnknown);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.OFFERUNKNOWN_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            this.offerRepository.delete(this.findOfferById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.OFFER_NOT_FOUND_ERROR)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
