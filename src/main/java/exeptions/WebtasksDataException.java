package exeptions;

/**
 * @author nata
 * @version 1.0
 */
public class WebtasksDataException extends WebtasksException {
	private static final long serialVersionUID = 4615969456856529371L;

	public WebtasksDataException(String message) {
		super(message);
	}

	public WebtasksDataException(Throwable cause) {
		super(cause);
	}

	public WebtasksDataException(String message, Throwable cause) {
		super(message, cause);
	}

}
