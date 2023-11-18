package shuaikai.utils.exception;

public class LCExceptionFactory {
    public static LCRuntimeException genRuntimeException(String msg) {
        return genRuntimeException(msg, Problem.Severity.ERROR);
    }

    public static LCRuntimeException genRuntimeException(String msg, Problem.Severity severity) {
        return genRuntimeException(msg, "", severity);
    }

    public static LCRuntimeException genRuntimeException(String msg, String path, Problem.Severity severity) {
        LCRuntimeException rte = new LCRuntimeException();
        rte.description = msg;
        rte.path = path;
        rte.severity = severity;
        return rte;
    }
}
