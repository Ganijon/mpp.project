

public class Address {

    private String strret;
    private String city;
    private String State;
    private String zip;

    public Address(String strret, String city, String State, String zip) {
        this.strret = strret;
        this.city = city;
        this.State = State;
        this.zip = zip;
    }

    public String getStrret() {
        return strret;
    }

    public void setStrret(String strret) {
        this.strret = strret;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    
    
}
