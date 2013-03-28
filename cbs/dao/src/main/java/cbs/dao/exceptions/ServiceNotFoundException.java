package cbs.dao.exceptions;

public class ServiceNotFoundException extends Exception {

    private static final long serialVersionUID = 7667678093027101029L;

    public ServiceNotFoundException() {
        super();
    }

    public ServiceNotFoundException(String message) {
        super(message);
    }

}
