package api.exceptions;

public class YamlFileNotFoundException extends ApiException {

    private static final long serialVersionUID = 3886231640831810298L;

    public static final String DESCRIPTION = "YAML file not found";

    public static final int CODE = 6;

    public YamlFileNotFoundException() {
        this("");
    }

    public YamlFileNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
