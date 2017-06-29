package api.exceptions;

public class UserNotDeleteException extends ApiException {

    public static final String DESCRIPTION = "No es posible eliminar el usuario";

    public static final int CODE = 99;

    private static final long serialVersionUID = -1344640670884805385L;

    public UserNotDeleteException() {
        this("");
    }

    public UserNotDeleteException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
