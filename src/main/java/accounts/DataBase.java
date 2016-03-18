package accounts;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DataBase {

	private static final DataBase INSTANCE = new DataBase();

	private DataBase() {
	}

	public static DataBase getInstance() {
		return INSTANCE;
	}

	public Document getUserData(User user) throws NoSuchUserException {

		if (user == null || user.getUsername() == null) {
			throw new NoSuchUserException();
		}

		MongoClient mongoClient = new MongoClient("localhost", 27017);

		MongoDatabase db = mongoClient.getDatabase("tmsDB");
		MongoCollection<Document> usersColl = db.getCollection("users");

		Bson nameFilter = Filters.eq("username", user.getUsername());

		Document mongoUser = usersColl.find(nameFilter).first();
		mongoClient.close();

		if (mongoUser == null) {
			throw new NoSuchUserException();
		}
		
		mongoUser.remove("password");
		mongoUser.remove("%oid");
		
		return mongoUser;
	}

}
