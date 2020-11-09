package database;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import org.bson.conversions.*;
import com.mongodb.client.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 * @author Marius on 2020-11-03.
 * @version %I%, %G%
 */
public class Login {

    private static Dotenv dotenv = Dotenv.load();
    private static ConnectionString uri = new ConnectionString(dotenv.get("CONNECTION_STRING"));
    private static MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(uri)
            .retryWrites(true)
            .build();
    private static MongoClient mongoClient = MongoClients.create(settings);
    private static MongoDatabase database = mongoClient.getDatabase("app");
    private static MongoCollection<Document> collection = database.getCollection("users");

    public static boolean areCredentialsValid(String usernameOrEmail, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {

        Document user = collection.find(
                Filters.or(
                        Filters.eq("username", usernameOrEmail),
                        Filters.eq("email", usernameOrEmail)
                )
        ).first();

        assert user != null;
        if (PasswordHash.validatePassword(password, user.getString("password"))){
            loginUser(usernameOrEmail, password);
            return true;
        }
        return false;
    }

    private static void loginUser(String usernameOrEmail, String password){
        //TODO: What to do when the user logs in
    }

}
