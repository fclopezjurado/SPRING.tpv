package api.exceptions;

public class StockNotEnoughException extends ApiException {

    private static final long serialVersionUID = -3273789534340515643L;

    public static final String DESCRIPTION = "There is not enough article stock";

    public static final int CODE = 11;

    public StockNotEnoughException() {
        this("");
    }

    public StockNotEnoughException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
