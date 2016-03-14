package registration;

import org.bson.Document;
import org.bson.conversions.Bson;

import accounts.User;
import accounts.UserUtils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public final class Registrator {

	private Registrator() {
	}

	public static void register(User user)
			throws UsernameAlreadyInUseException, EmailAlreadyInUseException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		MongoDatabase db = mongoClient.getDatabase("tmsDB");
		MongoCollection<Document> usersColl = db.getCollection("users");

		Bson usernameFilter = Filters.eq("username", user.getUsername());
		Document mongoUser = usersColl.find(usernameFilter).first();
		if (mongoUser != null) {
			mongoClient.close();
			throw new UsernameAlreadyInUseException();
		}
		
		/* Bson emailFilter = Filters.eq("email", user.getEmail());
		 * Document mongoUser = usersColl.find(emailFilter).first();
			if (mongoUser != null) {
				throw new EmailAlreadyInUseException();
			} 
		*/
		usersColl.insertOne(UserUtils.getMongoUser(user));

		mongoClient.close();
	}
}
