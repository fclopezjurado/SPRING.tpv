package api.exceptions;

public class UserFieldAlreadyExistException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "The mobile or email field already exists in database";

    public static final int CODE = 1;

    public UserFieldAlreadyExistException() {
        this("");
    }

    public UserFieldAlreadyExistException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
