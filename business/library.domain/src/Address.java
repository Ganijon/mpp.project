
import java.io.Serializable;

public class Address implements Serializable {

    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String strret, String city, String State, String zip) {
        this.street = strret;
        this.city = city;
        this.state = State;
        this.zip = zip;
    }

    public String getStrret() {
        return street;
    }

    public void setStrret(String strret) {
        this.street = strret;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String State) {
        this.state = State;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Street:");
        sb.append(street);
        sb.append(" City:");
        sb.append(city);
        sb.append(" State:");
        sb.append(state);
        sb.append(" Zip:");
        sb.append(zip);
        return sb.toString();
    }

}
