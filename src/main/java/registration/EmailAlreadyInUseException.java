package registration;

public class EmailAlreadyInUseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public EmailAlreadyInUseException() {
		super();
	}

	public EmailAlreadyInUseException(String message) {
		super(message);
		this.message = message;
	}

	public EmailAlreadyInUseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public EmailAlreadyInUseException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public EmailAlreadyInUseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}

}
