package database;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;
import org.bson.Document;

/**
 * @author Marius on 2020-11-03.
 * @version %I%, %G%
 */
public class Login {

    public static boolean areCredentialsValid(String usernameOrEmail, String password){
        //TODO: Check if the users credentials are valid
        if (true) {
            loginUser(usernameOrEmail, password);
        }
        return true;
    }

    private static void loginUser(String usernameOrEmail, String password){
        //TODO: What to do when the user logs in
    }

}
