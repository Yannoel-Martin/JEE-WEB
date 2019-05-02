package exceptions;

/**
 * Exception thrown when an element is not found.
 */
public class NotFoundException extends Exception {

    /** Serial number. */
    private static final long serialVersionUID = 1473684668098975313L;

    public NotFoundException(final String message) {
        super(message);
    }
}
