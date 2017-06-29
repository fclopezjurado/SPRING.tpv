package api.exceptions;

public class TicketReferenceNotFoundException extends ApiException {
    private static final long serialVersionUID = 3117076866914877491L;

    public static final String DESCRIPTION = "Ticket reference provided not found";

    public static final int CODE = 10;

    public TicketReferenceNotFoundException() {
        this("");
    }

    public TicketReferenceNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
