package services;

import models.User;
import models.Student;
import models.Admin;
import utils.DataPersistence;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {
    private Map<String, User> users;
    private DataPersistence dataPersistence;
    
    public UserService() {
        this.dataPersistence = new DataPersistence();
        this.users = loadUsers();
    }
    
    @SuppressWarnings("unchecked")
    private Map<String, User> loadUsers() {
        Map<String, User> loadedUsers = (Map<String, User>) dataPersistence.loadData("users.dat");
        if (loadedUsers == null) {
            loadedUsers = new HashMap<>();
            // Create default admin
            Admin defaultAdmin = new Admin("admin-001", "admin", "admin123", 
                    "admin@elearning.com", "System Administrator");
            loadedUsers.put(defaultAdmin.getUsername(), defaultAdmin);
            saveUsers();
        }
        return loadedUsers;
    }
    
    private void saveUsers() {
        dataPersistence.saveData(users, "users.dat");
    }
    
    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    
    public boolean registerStudent(String username, String password, String email, String fullName) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        
        String userId = "student-" + UUID.randomUUID().toString().substring(0, 8);
        Student student = new Student(userId, username, password, email, fullName);
        users.put(username, student);
        saveUsers();
        return true;
    }
    
    public boolean registerAdmin(String username, String password, String email, String fullName) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        
        String userId = "admin-" + UUID.randomUUID().toString().substring(0, 8);
        Admin admin = new Admin(userId, username, password, email, fullName);
        users.put(username, admin);
        saveUsers();
        return true;
    }
    
    public User getUserByUsername(String username) {
        return users.get(username);
    }
    
    public Map<String, User> getAllUsers() {
        return new HashMap<>(users);
    }
}
