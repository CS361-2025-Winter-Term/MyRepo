public class Admin extends User {
    private String adminRole;  // Defines specific role (e.g., "Super Admin")

    public Admin(String username, String password, String email, String notificationPreferences, String adminRole) {
        super(username, password, email, notificationPreferences);
        this.adminRole = adminRole;
    }

    // Admin-specific methods
    public void deleteUser(User user) {
        System.out.println("Admin " + username + " deleted user: " + user.getUsername());
    }

    public void modifyUserDetails(User user, String newEmail) {
        user.setEmail(newEmail);
        System.out.println("Admin updated user " + user.getUsername() + " email to: " + newEmail);
    }
}
