package org.example.repository;

import org.example.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * in memory db용 repository
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public class UserRepository {
    private static Map<String, User> users = new HashMap<>();

    public static void save(User user){
        users.put(user.getUserId(),user);
    }

    public static Collection<User> findAll() {
        return users.values();
    }
}
