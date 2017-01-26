
import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {

    private final LocalDate checkoutDate;
    private final LocalDate dueDate;
    private final int bookCopyId;

    public CheckoutEntry(LocalDate checkoutDate, LocalDate dueDate, int bookCopyId) {
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.bookCopyId = bookCopyId;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getBookCopyId() {
        return bookCopyId;
    }
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" BookCopyID:");
        sb.append(bookCopyId);
        sb.append(" CheckoutDate:");
        sb.append(checkoutDate);
        sb.append(" DueDate:");
        sb.append(dueDate);
        return sb.toString();
    }
}
