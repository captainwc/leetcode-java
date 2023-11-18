package shuaikai.utils.exception;

import java.util.PropertyResourceBundle;

public class LCRuntimeException extends RuntimeException implements Problem {

    protected String path = "";
    protected String description;
    protected Severity severity;

    /**
     * Use {@link LCExceptionFactory} instead
     */
    protected LCRuntimeException() {
    }


    @Override
    public String getLocation() {
        return path;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Severity getSeverity() {
        return severity;
    }
}
