package app.preciojusto.products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(){}
    public ResourceNotFoundException(ApplicationExceptionCode code)
    {
        super(Integer.toString(code.getCode()));
    }

}