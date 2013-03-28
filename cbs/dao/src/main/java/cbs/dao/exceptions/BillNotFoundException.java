package cbs.dao.exceptions;

public class BillNotFoundException extends Exception {

    private static final long serialVersionUID = 524205285495411200L;

    public BillNotFoundException() {
        super();
    }

    public BillNotFoundException(String message) {
        super(message);
    }

}
