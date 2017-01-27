
import java.io.Serializable;
import java.time.LocalDate;

public final class CheckoutEntry implements Serializable {

    private final LocalDate checkoutDate;
    private final LocalDate dueDate;
    private final String bookISBN;
    private final String bookCopyId;
    private final String memberId;

    public CheckoutEntry(LocalDate checkoutDate, LocalDate dueDate, String ISBN, String bookCopyId, String memberId) {
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.bookISBN = ISBN;
        this.bookCopyId = bookCopyId;
        this.memberId = memberId;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ISBN:");
        sb.append(bookISBN);
        sb.append(" BookCopyID:");
        sb.append(bookCopyId);
        sb.append(" MemberID:");
        sb.append(memberId);
        sb.append(" CheckoutDate:");
        sb.append(checkoutDate);
        sb.append(" DueDate:");
        sb.append(dueDate);
        return sb.toString();
    }
}
