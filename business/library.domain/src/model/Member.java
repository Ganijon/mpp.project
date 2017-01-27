package model;

import java.io.Serializable;

public class Member extends Person implements Serializable {

    private String memberId;

    public Member(String FirstName, String LastName, String PhoneNumber, Address address) {
        super(FirstName, LastName, PhoneNumber, address);
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String id) {
        memberId = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MemberID:");
        sb.append(memberId);
        sb.append(super.toString());
        return sb.toString();
    }
}
