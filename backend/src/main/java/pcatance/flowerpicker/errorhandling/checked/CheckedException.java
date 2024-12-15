package pcatance.flowerpicker.errorhandling.checked;

import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckedException extends Exception {
    private String errorCode;
    private Response.Status status;
    private String message;
    private String details;
}
