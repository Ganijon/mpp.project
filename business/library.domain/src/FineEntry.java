
import java.io.Serializable;
import java.time.LocalDate;

public class FineEntry implements Serializable {

    private final LocalDate paidDate;
    private final LocalDate lateReturn;

    public FineEntry(LocalDate paidDate, LocalDate lateReturn) {
        this.paidDate = paidDate;
        this.lateReturn = lateReturn;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public LocalDate getLateReturn() {
        return lateReturn;
    }
 @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" PaidDate:");
        sb.append(paidDate);
        sb.append(" LateReturn:");
        sb.append(lateReturn);
        return sb.toString();
    }
}
