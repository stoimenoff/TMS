package registration;

public class UsernameAlreadyInUseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UsernameAlreadyInUseException() {
		super();
	}

	public UsernameAlreadyInUseException(String message) {
		super(message);
		this.message = message;
	}

	public UsernameAlreadyInUseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UsernameAlreadyInUseException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public UsernameAlreadyInUseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}

}
