package pl.sda.sdaspringtraining.api;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.sdaspringtraining.NotFoundException;

@ControllerAdvice
public class CarRentExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public String handleNotExist(NotFoundException ex) {
        return "Podany przez Ciebie obiekt nie istnieje, wiadomość serwera: " + ex.getMessage();
    }
}
