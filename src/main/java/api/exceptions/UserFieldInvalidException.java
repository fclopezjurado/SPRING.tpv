package api.exceptions;

public class UserFieldInvalidException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "User field is empty or nonexisten";

    public static final int CODE = 2;

    public UserFieldInvalidException() {
        this("");
    }

    public UserFieldInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
