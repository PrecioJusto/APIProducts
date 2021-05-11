package app.preciojusto.products.services;

import app.preciojusto.products.entities.Container;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.ResourceAlreadyExistsException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.repositories.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContainerServiceImpl implements ContainerService {

    @Autowired
    private ContainerRepository containerRepository;

    @Override
    public Optional<Container> findById(Long id) {
        return this.containerRepository.findById(id);
    }

    @Override
    public Container save(Container request) throws ResourceNotFoundException {
        Container container;
        if (request.getContid() != null) {
            container = this.findById(request.getContid()).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CONTAINER_NOT_FOUND_ERROR));
            container.setConttype(request.getConttype());
            container.setContcapacity(request.getContcapacity());
            container.setContunit(request.getContunit());
        } else container = request;
        try {
            return this.containerRepository.save(container);
        } catch (Exception e) {
            throw new ResourceAlreadyExistsException(ApplicationExceptionCode.CONTAINER_ALREADY_EXISTS_ERROR);
        }
    }

    @Override
    public Boolean delete(Long id) throws ResourceNotFoundException {
        try {
            this.containerRepository.delete(this.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.BRAND_NOT_FOUND_ERROR)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
