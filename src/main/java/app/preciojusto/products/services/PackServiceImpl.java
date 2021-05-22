package app.preciojusto.products.services;

import app.preciojusto.products.entities.Pack;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackServiceImpl implements PackService {

    @Autowired
    private PackRepository packRepository;

    @Override
    public Optional<Pack> findById(Long id) {
        return this.packRepository.findById(id);
    }

    @Override
    public List<Pack> findAll() {
        return this.packRepository.findAll();
    }

    @Override
    public Optional<Pack> findByPackquantity(Integer quantity) {
        return this.packRepository.findByPackquantity(quantity);
    }

    @Override
    public Pack save(Pack request) throws ResourceNotFoundException {
        Pack pack;
        if (request.getPackid() != null) {
            pack = this.findById(request.getPackid()).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PACK_NOT_FOUND_ERROR));
            pack.setPackquantity(request.getPackquantity());
        } else pack = request;
        try {
            return this.packRepository.save(pack);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.PACK_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Boolean delete(Long id) throws ResourceNotFoundException {
        try {
            this.packRepository.delete(this.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.PACK_NOT_FOUND_ERROR)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
