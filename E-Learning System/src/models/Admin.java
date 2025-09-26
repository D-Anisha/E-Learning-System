package models;

public class Admin extends User {
    private static final long serialVersionUID = 1L;
    
    public Admin(String userId, String username, String password, String email, String fullName) {
        super(userId, username, password, email, fullName);
    }
    
    @Override
    public String getRole() {
        return "ADMIN";
    }
}
