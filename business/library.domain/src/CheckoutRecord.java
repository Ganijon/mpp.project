
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CheckoutRecord implements Serializable {

    private int memberId;
    private List<CheckoutEntry> checkouts;
    private List<FineEntry> fines;

    public CheckoutRecord(int memberId, CheckoutEntry[] checkouts, FineEntry[] fines) {
        this.memberId = memberId;
        this.checkouts = Arrays.asList(checkouts);
        this.fines = Arrays.asList(fines);
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
        sb.append(" Member ID:");
        sb.append(memberId);
        sb.append(" Checkouts:");
        sb.append(checkouts.toString());
        sb.append(" Fines:");
        sb.append(fines.toString());
        return sb.toString();
    }
}
