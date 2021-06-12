package app.preciojusto.products.services;

import app.preciojusto.products.DTOs.SupermarketImageDTO;
import app.preciojusto.products.entities.Supermarket;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.SupermarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class SupermarketServiceImpl implements SupermarketService {

    @Autowired
    private SupermarketRepository supermarketRepository;

    @Override
    public Optional<Supermarket> findById(Long id) {
        return this.supermarketRepository.findById(id);
    }

    @Override
    public List<Supermarket> findAll() {
        return this.supermarketRepository.findAll();
    }

    @Override
    public Supermarket save(Supermarket request) throws ResourceNotFoundException {
        Supermarket supermarket;
        if (request.getSupeid() != null) {
            supermarket = this.findById(request.getSupeid())
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKET_NOT_FOUND_ERROR));
            supermarket.setSupename(request.getSupename());
        } else supermarket = request;
        try {
            return this.supermarketRepository.save(supermarket);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.SUPERMARKET_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Supermarket saveImg(SupermarketImageDTO request) {
        Supermarket s = this.findById(request.getSupeid())
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKET_NOT_FOUND_ERROR));
        s.setSupeimg(Base64.getDecoder().decode(request.getImgBase64()));
        return this.save(s);
    }

    @Override
    public Optional<Supermarket> findBySupenameEquals(String name) {
        return this.supermarketRepository.findBySupenameEquals(name);
    }

    @Override
    public Boolean delete(Long id) throws ResourceNotFoundException {
        try {
            this.supermarketRepository.delete(this.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.SUPERMARKET_NOT_FOUND_ERROR)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
