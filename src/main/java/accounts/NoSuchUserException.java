package accounts;

public class NoSuchUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public NoSuchUserException() {
		super();
	}

	public NoSuchUserException(String message) {
		super(message);
		this.message = message;
	}

	public NoSuchUserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchUserException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public NoSuchUserException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}

}
