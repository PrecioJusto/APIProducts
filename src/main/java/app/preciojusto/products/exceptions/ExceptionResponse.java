package app.preciojusto.products.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
