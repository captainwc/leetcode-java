package shuaikai.utils.exception;

/**
 * Any problem that can occur in the program
 */
public interface Problem {
    public enum Severity {
        INFO,
        WARN,
        ERROR,
        FATAL
    }

    String getLocation();

    String getDescription();

    Severity getSeverity();
}
