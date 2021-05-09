package app.preciojusto.products.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException() {
    }

    public ResourceAlreadyExistsException(ApplicationExceptionCode code) {
        super(Integer.toString(code.getCode()));
    }
}