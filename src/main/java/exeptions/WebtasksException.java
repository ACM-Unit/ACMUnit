package exeptions;

/**
 * @author nata
 * @version 1.0
 */
public class WebtasksException extends Exception {
	private static final long serialVersionUID = 7803484175197842231L;

	public WebtasksException(String message) {
		super(message);
	}

	public WebtasksException(Throwable cause) {
		super(cause);
	}

	public WebtasksException(String message, Throwable cause) {
		super(message, cause);
	}
}
