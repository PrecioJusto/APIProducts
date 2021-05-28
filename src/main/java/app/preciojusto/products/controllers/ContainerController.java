package app.preciojusto.products.controllers;

import app.preciojusto.products.entities.Container;
import app.preciojusto.products.exceptions.ApplicationExceptionCode;
import app.preciojusto.products.exceptions.BadRequestException;
import app.preciojusto.products.exceptions.ResourceNotFoundException;
import app.preciojusto.products.services.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContainerController {

    @Autowired
    ContainerService containerService;

    @GetMapping("/containers")
    public List<Container> getContainer() {
        return this.containerService.findAll();
    }

    @GetMapping("/container/{id}")
    public Container getContainer(@PathVariable Long id) throws ResourceNotFoundException {
        return this.containerService.findById(id).orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CONTAINER_NOT_FOUND_ERROR));
    }

    @GetMapping("/container/byAttr")
    public Container getContainerByAttr(@RequestBody Container request) throws ResourceNotFoundException {
        return this.containerService.findContainerByContcapacityAndAndConttypeAndContunit(request.getContcapacity(), request.getConttype(), request.getContunit())
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationExceptionCode.CONTAINER_NOT_FOUND_ERROR));
    }

    @PostMapping("/container")
    public Container postAddContainer(@RequestBody Container request) throws ResourceNotFoundException {
        if (request.getContid() != null || request.getConttype() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.containerService.save(request);
    }

    @PutMapping("/container")
    public Container putUpdateContainer(@RequestBody Container request) throws ResourceNotFoundException {
        if (request.getContid() == null || request.getConttype() == null)
            throw new BadRequestException(ApplicationExceptionCode.BADREQUEST_ERROR);
        return this.containerService.save(request);
    }

    @DeleteMapping("/container/{id}")
    public Boolean deleteContainer(@PathVariable Long id) throws ResourceNotFoundException {
        return this.containerService.delete(id);
    }
}
