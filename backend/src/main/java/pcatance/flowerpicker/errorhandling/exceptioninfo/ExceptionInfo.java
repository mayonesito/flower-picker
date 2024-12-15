package pcatance.flowerpicker.errorhandling.exceptioninfo;

import jakarta.ws.rs.core.Response;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ExceptionInfo {
    CANNOT_FETCH_FLOWERS(
            "CANNOT_FETCH_FLOWERS",
            Response.Status.INTERNAL_SERVER_ERROR,
            "Could not fetch flowers"
    );

    private final String errorCode;
    private final Response.Status status;
    private final String message;

    ExceptionInfo(String errorCode,
                  Response.Status status,
                  String message) {
        this.errorCode = errorCode;
        this.status = status;
        this.message = message;
    }

}
