package foromusicos.apirestreto.seguridad;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Map<String, Object> body(HttpStatus status, String mensaje) {

        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("codigo", status.value());
        error.put("error", status.getReasonPhrase());
        error.put("mensaje", mensaje);

        return error;
    }

    //400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validacion(MethodArgumentNotValidException ex) {

        String mensaje = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ResponseEntity
                .badRequest()
                .body(body(HttpStatus.BAD_REQUEST, mensaje));
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraint(ConstraintViolationException ex) {

        return ResponseEntity
                .badRequest()
                .body(body(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    //404
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtime(RuntimeException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    //500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> general(Exception ex) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor"));
    }
}
