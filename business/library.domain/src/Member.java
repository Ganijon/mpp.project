

public class Member extends Person {
    
    private int MemberID;
    static private int instance=0;

    public Member(String FirstName, String LastName, String PhoneNumber, Address address) {
        super(FirstName, LastName, PhoneNumber, address);
        this.MemberID = MemberID;
    }

    

    public int getMemberID() {
        return MemberID;
    }

    
    
    
}
