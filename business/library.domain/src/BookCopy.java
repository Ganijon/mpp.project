
import java.io.Serializable;

public class BookCopy implements Serializable {

    private int bookCopyId;
    private boolean isAvailable;

    public BookCopy() {
        this.bookCopyId = 0;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" BookCopyId:");
        sb.append(bookCopyId);

        sb.append(" Available:");
        sb.append(isAvailable ? "yes" : "no");

        return sb.toString();
    }

}
