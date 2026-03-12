
    package service;

import java.util.HashMap;
import model.User;

public class AuthService {

    private static HashMap<String, User> users = new HashMap<>();

    // Static block to create default users
    static {

        users.put("student1", new User("student1", "USER"));
        users.put("faculty1", new User("faculty1", "AUTHORITY"));
        users.put("admin", new User("admin", "ADMIN"));

    }

    public static User login(String userId) {

        if(users.containsKey(userId)) {
            return users.get(userId);
        }

        return null;
    }


}
