package authentication;

import org.bson.Document;
import org.bson.conversions.Bson;

import accounts.User;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public final class UserAuthenticator {
	
	private UserAuthenticator() {
	}
	
	public static boolean authenticate(User user) {
		
		if(user.getPassword() == null || user.getUsername() == null) {
			return false;
		}
		
		MongoClient mongoClient = new MongoClient("localhost" , 27017);
		
		MongoDatabase db = mongoClient.getDatabase("tmsDB");
		MongoCollection<Document> usersColl = db.getCollection("users");
		
		Bson nameFilter = Filters.eq("username", user.getUsername());
		Bson passFilter = Filters.eq("password", user.getPassword());
		
		Document mongoUser = usersColl.find(Filters.and(nameFilter, passFilter)).first();
		mongoClient.close();
		
		return mongoUser != null;
	}
	
}
