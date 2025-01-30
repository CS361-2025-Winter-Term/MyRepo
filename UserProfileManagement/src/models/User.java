import java.util.HashSet;
import java.util.Set;

public class User {
    // Static set to ensure unique usernames
    private static final Set<String> usernames = new HashSet<>();

    // Attributes
    protected String username;  // Unique identifier for the user
    protected String email;     // User's email address
    protected String notificationPreferences;  // Notification settings
    private String passwordHash;  // Password stored securely (to be hashed)

    // Constructor
    public User(String username, String password, String email, String notificationPreferences) {
        if (!isValidUsername(username)) {
            throw new IllegalArgumentException("Invalid username: Must be unique and follow naming rules.");
        }
        this.username = username;
        this.passwordHash = password; // Temporary, will be hashed later
        this.email = email;
        this.notificationPreferences = notificationPreferences;
        usernames.add(username);
    }

    // Getters
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getNotificationPreferences() { return notificationPreferences; }

    // Setters
    public void setEmail(String email) { this.email = email; }
    public void setNotificationPreferences(String notificationPreferences) { this.notificationPreferences = notificationPreferences; }

    // Private validation methods
    private boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9_-]{4,16}$") && !usernames.contains(username);
    }

    // Display user information (excluding password)
    public void displayUserInfo() {
        System.out.println("User Profile:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Notification Preferences: " + notificationPreferences);
    }
}
