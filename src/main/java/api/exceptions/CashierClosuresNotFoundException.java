package api.exceptions;

public class CashierClosuresNotFoundException extends ApiException {

	private static final long serialVersionUID = 5417661361405771382L;

	public static final String DESCRIPTION = "Not exists cashier clousures";

    public static final int CODE = 27;

    public CashierClosuresNotFoundException() {
        this("");
    }

    public CashierClosuresNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }
}
