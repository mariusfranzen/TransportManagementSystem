package database;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import org.bson.Document;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */
public class Connect {

    private ConnectionString uri = new ConnectionString("mongodb+srv://admin:admin@cluster0.vg2ir.mongodb.net/app?w=majority");
    private MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(uri)
            .retryWrites(true)
            .build();
    private MongoClient mongoClient = MongoClients.create(settings);
    private MongoDatabase database = mongoClient.getDatabase("app");
    private MongoCollection<Document> usersCollection = database.getCollection("users");

    public Connect() throws UnknownHostException {

    }

    public void pushUserToDB(User user){
        usersCollection.insertOne(user.getAsDocument());
    }

}
