package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class CheckoutRecord implements Serializable {

    private final String memberId;
    private final List<CheckoutEntry> checkouts;
    private final List<FineEntry> fines;

    public CheckoutRecord(String memberId) {
        this.memberId = memberId;
        this.checkouts = new ArrayList<>();
        this.fines = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public List<CheckoutEntry> getCheckouts() {
        return checkouts;
    }

    public List<FineEntry> getFines() {
        return fines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MemberID:");
        sb.append(memberId);
        sb.append(" Checkouts:");
        sb.append(checkouts.toString());
        sb.append(" Fines:");
        sb.append(fines.toString());
        return sb.toString();
    }
}
