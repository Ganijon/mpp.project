
import java.util.HashMap;



public class UserAccounts {
    private static HashMap<String, UserAccount> data = new HashMap<>();
    
    static {
       data.put("lib", new UserAccount("lib", "lib", Access.Librarian)); 
       data.put("admin", new UserAccount("admin", "admin", Access.Admin)); 
       data.put("both", new UserAccount("both", "both", Access.Both)); 
    }
    
    public static UserAccount GetUserAccount(String userName, String password) {
        if(IsRegistered(userName, password)) {
            return data.get(userName);
        }
        return null;
    }
    
    public static boolean IsRegistered(String userName, String password) {
        
        if(data.containsKey(userName))
        {
            UserAccount ua = data.get(userName);
            
            return ua.getPassword().equals(password);
        }
        return false;
    }
}
