package accounts;

public class User {
	
	private static long ID = 0;
	
	private final String username;
	private final String password;
	private final long id;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		ID += 1;
		this.id = ID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public long getId() {
		return id;
	}
	
}
