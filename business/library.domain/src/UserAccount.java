

public class UserAccount {

    private String userName;
    private String password;
    private Access access;

    public UserAccount(String userName, String password, Access access) {
        this.userName = userName;
        this.password = password;
        this.access = access;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Access getAccess() {
        return access;
    }
}
