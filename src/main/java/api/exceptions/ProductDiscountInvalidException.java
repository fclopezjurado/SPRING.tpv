package api.exceptions;

public class ProductDiscountInvalidException extends ApiException {
    private static final long serialVersionUID = -6099784745820921879L;

    public static final String DESCRIPTION = "Product discount is less than 0% or greater than 100%";

    public static final int CODE = 15;

    public ProductDiscountInvalidException() {
        this("");
    }

    public ProductDiscountInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
