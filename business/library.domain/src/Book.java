
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Book implements Serializable {

    private String title;
    private String ISBN;
    private int issueLength;
    private List<BookCopy> copies;
    private List<Author> authors;

    public Book(String title, String ISBN, int issueLength) {
        this.title = title;
        this.ISBN = ISBN;
        this.issueLength = issueLength;
        this.authors = new ArrayList<>();
        this.copies = new ArrayList<>();
        addBookCopy();
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

    public List<BookCopy> getBookCopies() {
        return copies;
    }

    public void setBookCopies(List<BookCopy> copies) {
        this.copies = copies;
    }
    public String getAuthors() {
        return authors.get(0).getFirstName();
    }

    public void addBookCopy() {
        String id = Integer.toString(copies.size() + 1);
        copies.add(new BookCopy(id));
    }

    public void addAuthor(Author a) {
        authors.add(a);
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
