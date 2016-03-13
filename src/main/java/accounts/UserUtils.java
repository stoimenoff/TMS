package accounts;

import org.bson.Document;

public final class UserUtils {

	private UserUtils() {
	}

	public static Document getMongoUser(User user) {
		Document mongoUser = new Document();
		mongoUser.append("username", user.getUsername());
		mongoUser.append("password", user.getPassword());
		return mongoUser;
	}
}
