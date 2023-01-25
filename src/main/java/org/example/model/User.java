package org.example.model;

/**
 * user model
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/25
 */
public class User {

    private final String userId;
    private final String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getName() {
        return name;
    }
}
