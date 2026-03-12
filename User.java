package model;

public class User {
   

    private String userId;
    private String role;

    public User(String userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

}
