package database;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */
public class User {

    private String username;
    private String email;
    private byte[] password;

    public Document getAsDocument(){
        return new Document()
                .append("username", this.username)
                .append("email", this.email)
                .append("password", this.password);
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

    public byte[] getPassword() {
        return password;
    }

    public User setPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        this.password = factory.generateSecret(spec).getEncoded();
        return this;
    }
}
