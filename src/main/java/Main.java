import database.Connect;
import database.User;

import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marius on 2020-11-02.
 * @version %I%, %G%
 */
public class Main {

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, UnknownHostException {

        List<User> usersToBeAdded = new ArrayList<User>();
        Connect connect = new Connect();

        User testUser = new User().setUsername("test").setEmail("test@gmail.com").setPassword("testtest123");
        usersToBeAdded.add(testUser);

        for (User user : usersToBeAdded){
            connect.pushUserToDB(user);
        }

    }

}
