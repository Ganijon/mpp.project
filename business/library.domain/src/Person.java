
import java.io.Serializable;

public abstract class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;

    public Person(String FirstName, String LastName, String PhoneNumber, Address address) {
        this.firstName = FirstName;
        this.lastName = LastName;
        this.phoneNumber = PhoneNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.phoneNumber = PhoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" First name:");
        sb.append(firstName);
        sb.append(" Last name:");
        sb.append(lastName);
        sb.append(" Phone number:");
        sb.append(phoneNumber);
        sb.append(" Address: {");
        sb.append(address.toString());
        sb.append("}");
        return sb.toString();
    }

}
