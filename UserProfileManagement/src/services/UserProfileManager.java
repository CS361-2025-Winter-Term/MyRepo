import java.util.ArrayList;
import java.util.List;

public class UserProfileManager {
    private List<User> users;  // Stores all user profiles

    public UserProfileManager() {
        this.users = new ArrayList<>();
    }

    // Create a new user and add to the list
    public void createUser(String username, String password, String email, String notificationPreferences) {
        User user = new User(username, password, email, notificationPreferences);
        users.add(user);
        System.out.println("User " + username + " created successfully.");
    }

    // Find user by username
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Delete a user
    public boolean deleteUser(String username) {
        return users.removeIf(user -> user.getUsername().equals(username));
    }
}
