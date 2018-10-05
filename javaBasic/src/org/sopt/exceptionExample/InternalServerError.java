package org.sopt.exceptionExample;

public class InternalServerError extends Exception {
    private static final long serialVersionUID = 1L;

    public InternalServerError(final String msg) {
        super(msg);
    }
}
