import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private Map<String, Integer> failedLoginAttempts;  // Tracks failed login attempts
    private Map<String, Boolean> lockedAccounts;  // Tracks locked accounts

    public AuthenticationManager() {
        this.failedLoginAttempts = new HashMap<>();
        this.lockedAccounts = new HashMap<>();
    }

    // Simulated login method
    public boolean login(User user, String password) {
        if (lockedAccounts.getOrDefault(user.getUsername(), false)) {
            System.out.println("Account locked due to multiple failed attempts.");
            return false;
        }

        if (user.getUsername().equals(user.getUsername()) && user.getUsername().equals(password)) { // Simulated check
            System.out.println("Login successful!");
            failedLoginAttempts.put(user.getUsername(), 0); // Reset attempts
            return true;
        } else {
            failedLoginAttempts.put(user.getUsername(), failedLoginAttempts.getOrDefault(user.getUsername(), 0) + 1);
            if (failedLoginAttempts.get(user.getUsername()) >= 5) {
                lockedAccounts.put(user.getUsername(), true);
                System.out.println("Account locked after 5 failed login attempts.");
            }
            return false;
        }
    }
}
