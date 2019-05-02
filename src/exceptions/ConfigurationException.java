package exceptions;

/**
 * Exception raised when a configuration error occurs.
 */
public class ConfigurationException extends RuntimeException {

    /** Serial number*/
    private static final long serialVersionUID = -9118351224946213445L;

    public ConfigurationException(final String message) {
        super(message);
    }

    public ConfigurationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(final Throwable cause) {
        super(cause);
    }
}
