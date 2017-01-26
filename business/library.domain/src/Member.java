
import java.io.Serializable;

public class Member extends Person implements Serializable {
    
    private int memberID;
    static private int instance=0;

    public Member(String FirstName, String LastName, String PhoneNumber, Address address) {
        super(FirstName, LastName, PhoneNumber, address);
        this.memberID = memberID;
    }

    public int getMemberID() {
        return memberID;
    }
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Member ID:");
        sb.append(memberID);
        sb.append(super.toString());
        return sb.toString();
    }
    
}
