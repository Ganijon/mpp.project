
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {

    private int memberId;
    private List<CheckoutEntry> checkouts;
    private List<FineEntry> fines;

    public CheckoutRecord(int memberId) {
        this.memberId = memberId;
        this.checkouts = new ArrayList<>();
        this.fines = new ArrayList<>();
    }

    public int getMemberId() {
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
        sb.append(" MemberID:");
        sb.append(memberId);
        sb.append(" Checkouts:");
        sb.append(checkouts.toString());
        sb.append(" Fines:");
        sb.append(fines.toString());
        return sb.toString();
    }

    boolean hasRecords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
