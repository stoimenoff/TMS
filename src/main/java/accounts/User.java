package accounts;

public class User {

	private static long ID = 0;

	private final long id;
	private final String username;
	private final String password;
	private final String email;
	private final String firstname;
	private final String lastname;

	public User(String username, String password) {
		this(username, password, null, null, null);
	}

	public User(String username, String password, String email,
			String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstName;
		this.lastname = lastName;
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

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", firstName=" + firstname
				+ ", lastName=" + lastname + "]";
	}

}
