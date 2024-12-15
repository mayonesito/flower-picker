package pcatance.flowerpicker.errorhandling.checked;

import pcatance.flowerpicker.errorhandling.exceptioninfo.ExceptionInfo;

public class FlowerException extends CheckedException{
    public FlowerException(ExceptionInfo exception, String details) {
        this.setErrorCode(exception.getErrorCode());
        this.setStatus(exception.getStatus());
        this.setMessage(exception.getMessage());
        this.setDetails(details);
    }
}
