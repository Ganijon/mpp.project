package app;

import model.Access;
import model.UserAccount;
import java.util.HashMap;

public class UserAccounts {

    private static final HashMap<String, UserAccount> DATA;

    private static UserAccount currentUser;

    static {
        DATA = new HashMap<>();
        DATA.put("admin", new UserAccount("admin", "admin", Access.Admin));
        DATA.put("lib", new UserAccount("lib", "lib", Access.Librarian));
        DATA.put("both", new UserAccount("both", "both", Access.Both));
    }

    public static boolean Login(String userName, String password) {

        if (DATA.containsKey(userName)) {
            UserAccount user = DATA.get(userName);
            if (user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public static boolean Logout() {
        return currentUser == null;
    }

    public static String getUserName() {
        return IsLoggedIn() ? currentUser.getUserName() : null;
    }

    public static Access getAccess() {
        return IsLoggedIn() ? currentUser.getAccess() : null;
    }

    public static boolean IsLoggedIn() {
        return currentUser != null;
    }

}
