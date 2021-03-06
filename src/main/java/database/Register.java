package database;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import org.bson.UuidRepresentation;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author Marius on 2020-11-03.
 * @version %I%, %G%
 */
public class Register {

    private static Dotenv dotenv = Dotenv.load();
    private static ConnectionString uri = new ConnectionString(dotenv.get("CONNECTION_STRING"));
    private static MongoClientSettings settings = MongoClientSettings.builder()
            .uuidRepresentation(UuidRepresentation.STANDARD)
            .applyConnectionString(uri)
            .retryWrites(true)
            .build();
    private static MongoClient mongoClient = MongoClients.create(settings);
    private static MongoDatabase database = mongoClient.getDatabase("app");
    private static MongoCollection<Document> collection = database.getCollection("users");

    public static void createAccount(String username, String email, String password, String passwordAgain) throws InvalidKeySpecException, NoSuchAlgorithmException {

        User newUser = new User();

        //TODO: checks for the username
        isUsernameOk(username);

        //TODO: checks for email
        isEmailOk(email);

        //TODO: checks for passwords
        doPasswordMatch(password, passwordAgain);

        newUser.setUsername(username).setEmail(email).setPassword(password);
        collection.insertOne(newUser.getAsDocument());
    }

    private static boolean isUsernameOk(String username){
        return true;
    }

    private static boolean isEmailOk(String email){
        return true;
    }

    private static boolean doPasswordMatch(String password, String passwordAgain){
        return true;
    }

}
