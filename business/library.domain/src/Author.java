

public class Author extends Person {

    private boolean credentials;
    private String ShortBio;

    public Author(boolean credentials, String ShortBio, String FirstName, String LastName, String PhoneNumber, Address address) {
        super(FirstName, LastName, PhoneNumber, address);
        this.credentials = credentials;
        this.ShortBio = ShortBio;
    }

    public boolean isCredentials() {
        return credentials;
    }

    public void setCredentials(boolean credentials) {
        this.credentials = credentials;
    }

    public String getShortBio() {
        return ShortBio;
    }

    public void setShortBio(String ShortBio) {
        this.ShortBio = ShortBio;
    }
    
    
}
