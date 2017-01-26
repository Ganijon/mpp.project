
import java.util.HashMap;

public class UserContext {

    private static HashMap<String, UserAccount> data = new HashMap<>();

    private static UserAccount currentUser;

    static {
        data.put("admin", new UserAccount("admin", "admin", Access.Admin));
        data.put("lib", new UserAccount("lib", "lib", Access.Librarian));
        data.put("both", new UserAccount("both", "both", Access.Both));
    }

    public static boolean Login(String userName, String password) {

        if (data.containsKey(userName)) {
            UserAccount user = data.get(userName);
            if (user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
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
