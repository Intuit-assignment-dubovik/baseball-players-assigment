package paveldubovik.baseball.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ApiError {
    private String status;
    private String reason;
    private String message;
    private String timestamp;
}
