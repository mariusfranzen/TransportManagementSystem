package database;

import org.bson.Document;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */

public class User {

    private UUID userId;
    private String username;
    private String email;
    private String password;

    public User(){
        userId = UUID.randomUUID();
    }

    public Document getAsDocument(){
        return new Document("_id", this.userId)
                .append("username", this.username)
                .append("email", this.email)
                .append("password", this.password);
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.password = PasswordHash.createHash(password);
        return this;
    }
}
