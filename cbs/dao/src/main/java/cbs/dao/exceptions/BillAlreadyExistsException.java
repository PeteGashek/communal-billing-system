package cbs.dao.exceptions;

public class BillAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 5708454055916623994L;

    public BillAlreadyExistsException() {
        super();
    }

    public BillAlreadyExistsException(String message) {
        super(message);
    }

}
