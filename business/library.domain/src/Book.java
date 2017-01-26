
import java.util.ArrayList;
import java.util.List;



public class Book {

    private String title;
    private String ISBN;
    private int issueLength;
    private List<BookCopy> copyList;
    private List<Author> authors;

    public Book(String title, String ISBN, int issueLength,BookCopy e) {
        this.title = title;
        this.ISBN = ISBN;
        this.issueLength = issueLength;
        copyList =  new ArrayList<>();
        copyList.add(e);
        Address a = new Address("1000 N 4th St","Fairfield","IA","12345");
        Author author =  new Author (true, "Saifullah Safdar the writter","Saifullah", "Safdar","6418095841", a);
        authors.add(author);
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addBook(BookCopy b) {
        copyList.add(b);
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
    
    
}
