package accounts;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public final class Registrator {

	private Registrator() {
	}
	
	public static void register(User user) {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		
		MongoDatabase db = mongoClient.getDatabase("tmsDB");
		MongoCollection<Document> usersColl = db.getCollection("users");
		
		usersColl.insertOne(UserUtils.getMongoUser(user));
		
		//System.out.println("New user");
		
		mongoClient.close();
	}
}
