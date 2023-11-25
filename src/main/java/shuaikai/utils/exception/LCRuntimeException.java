package shuaikai.utils.exception;

import java.util.function.Consumer;

/**
 * RuntimeExp, used to change the control flow, or wrap some problems.
 *
 * @author wddjwk
 */
public class LCRuntimeException extends RuntimeException implements Problem {
    protected String path = "";
    protected String description;
    protected Severity severity;
    protected Consumer<LCRuntimeException> handler = Throwable::printStackTrace;

    /**
     * Use {@link LCExceptionFactory} instead
     */
    protected LCRuntimeException() {
    }

    public void consumeSelf() {
        handler.accept(this);
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
