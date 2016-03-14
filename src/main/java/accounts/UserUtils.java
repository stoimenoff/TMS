package accounts;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.bson.Document;

import com.google.gson.Gson;

public final class UserUtils {

	private UserUtils() {
	}

	public static Document getMongoUser(User user) {
		Document mongoUser = new Document();
		mongoUser.append("username", user.getUsername());
		mongoUser.append("password", user.getPassword());
		mongoUser.append("email", user.getEmail());
		mongoUser.append("Firstname", user.getFirstname());
		mongoUser.append("Lastname", user.getLastname());
		return mongoUser;
	}

	public static User getUser(HttpServletRequest request) {
		String body;
		try {
			body = request.getReader().lines()
					.reduce("", (accumulator, actual) -> accumulator + actual);
		} catch (IOException e) {
			return null;
		}
		Gson gson = new Gson();
		return gson.fromJson(body.toString(), User.class);
	}

	public static boolean validateUserData(User user) {
		return  user != null
				&& validateUsername(user.getUsername())
				&& validatePassword(user.getPassword())
				&& validateName(user.getFirstname())
				&& validateName(user.getLastname())
				&& validateEmail(user.getEmail());
	}

	private static boolean validateUsername(String username) {
		// TODO match regex
		if (username == null || username.equals("")) {
			return false;
		}
		return true;
	}

	private static boolean validatePassword(String password) {
		return password != null && !password.equals("");
	}

	private static boolean validateName(String name) {
		return name != null && !name.equals("");
	}

	private static boolean validateEmail(String email) {
		Pattern emailValidator = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailValidator.matcher(email);
		return matcher.find();
	}

}
