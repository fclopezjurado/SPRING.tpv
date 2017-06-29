package api.exceptions;

public class ProductAmountInNewTicketInvalidException extends ApiException {
    private static final long serialVersionUID = 6970924166259598343L;

    public static final String DESCRIPTION = "Product amount is equal or less than 0 in new ticket";

    public static final int CODE = 12;

    public ProductAmountInNewTicketInvalidException() {
        this("");
    }

    public ProductAmountInNewTicketInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
