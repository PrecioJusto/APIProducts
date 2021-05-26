package app.preciojusto.products.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    @NonNull
    private HttpStatus statusError;

    private Long timestamp = System.currentTimeMillis();

    @NonNull
    private Integer messageError;
}
