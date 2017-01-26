
import java.io.Serializable;

public class Member extends Person implements Serializable {
    
    private int memberId;

    public Member(String FirstName, String LastName, String PhoneNumber, Address address) {
        super(FirstName, LastName, PhoneNumber, address);
    }

    public int getMemberID() {
        return memberId;
    }
    
    void setMemberID(int id) {
        memberId = id;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" MemberID:");
        sb.append(memberId);
        sb.append(super.toString());
        return sb.toString();
    }
}
