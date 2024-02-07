package paveldubovik.baseball.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @ExceptionHandler(PlayerNotFoundException.class)
    ResponseEntity<ApiError> playerNotFound(PlayerNotFoundException e) {
        log.warn("Exception: {}", e.getMessage());
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND.name())
                .reason("The required player was not found")
                .message(e.getMessage())
                .timestamp(LocalDateTime.now().format(FORMATTER))
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

}
