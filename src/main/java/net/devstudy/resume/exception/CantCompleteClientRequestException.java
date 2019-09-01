package net.devstudy.resume.exception;

public class CantCompleteClientRequestException extends RuntimeException {


    private static final long serialVersionUID = 4124519757959005105L;

    public CantCompleteClientRequestException(String message) {
        super(message);
    }

    public CantCompleteClientRequestException(Throwable cause) {
        super(cause);
    }

    public CantCompleteClientRequestException(String message, Throwable cause) {
        super(message, cause);
    }



}
