
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {

    private String title;
    private String ISBN;
    private int issueLength;
    private List<BookCopy> copies;
    private List<Author> authors;

    public Book(String title, String ISBN, int issueLength, BookCopy e) {
        this.title = title;
        this.ISBN = ISBN;
        this.issueLength = issueLength;
        copies = new ArrayList<>();
        copies.add(e);
        Address a = new Address("1000 N 4th St", "Fairfield", "IA", "12345");
        Author author = new Author("E. L.", "James", "555-4545-456", a, true,
                "Erika Mitchell, known by her pen name E. L. James, is an English author.");
        authors = new ArrayList<>();
        authors.add(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addBook(BookCopy b) {
        copies.add(b);
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

}
