package api.exceptions;

public class TicketUserInvalidException extends ApiException {

    private static final long serialVersionUID = -4328051169500985249L;
    
    public static final String DESCRIPTION = "Invalid user in ticket";

    public static final int CODE = 19;
    
    public TicketUserInvalidException() {
        this("");
    }
    
    public TicketUserInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }
   
}
