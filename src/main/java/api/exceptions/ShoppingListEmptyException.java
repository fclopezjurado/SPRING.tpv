package api.exceptions;

public class ShoppingListEmptyException extends ApiException {
    private static final long serialVersionUID = 7862705985622778351L;

    public static final String DESCRIPTION = "Product list in ticket is empty";

    public static final int CODE = 8;

    public ShoppingListEmptyException() {
        this("");
    }

    public ShoppingListEmptyException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
