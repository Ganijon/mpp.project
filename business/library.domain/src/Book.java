
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {

    private String title;
    private String ISBN;
    private int issueLength;
    private List<BookCopy> copies;
    private List<Author> authors;

    public Book(String title, String ISBN, int issueLength) {
        this.title = title;
        this.ISBN = ISBN;
        this.issueLength = issueLength;

        copies = new ArrayList<>();
        addBookCopy(new BookCopy());

        authors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getIssueLength() {
        return issueLength;
    }

    public void setIssueLength(int issueLength) {
        this.issueLength = issueLength;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Title:");
        sb.append(title);
        sb.append(" ISBN:");
        sb.append(ISBN);
        sb.append(" Issue Length:");
        sb.append(issueLength);
        sb.append(" Authors:");
        sb.append(authors.toString());
        sb.append(" Copies:");
        sb.append(copies.toString());
        return sb.toString();
    }

    public void addBookCopy(BookCopy b) {
        b.setBookCopyId(copies.size() + 1);
        copies.add(b);
    }

    public void addAuthor(Author a) {
        authors.add(a);
    }

}
