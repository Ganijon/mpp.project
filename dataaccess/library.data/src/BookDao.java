
import java.util.ArrayList;
import java.util.List;

public class BookDao implements Dao<Book> {

    public final static String FILENAME = "books.ser";

    private Serializer<List<Book>> serializer = new Serializer<>();

    @Override
    public List<Book> read() {
        return serializer.deSerialize(FILENAME);
    }

    @Override
    public boolean write(List<Book> list) {
        System.out.println("SAVING DATA: " + list.toString());
        return serializer.serialize(list, FILENAME);
    }

    @Override
    public boolean add(Book newBook) {
        List<Book> list = read();
        if (list == null) {
            write(new ArrayList<>());
            list = read();
        }
        list.add(newBook);
        return write(list);
    }

    //@Override
    public Book find(String ISBN) {
        List<Book> list = read();
        for (Book book : list) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public boolean update(Book data) {
        List<Book> list = read();
        for (Book book : list) {
            if (book.getISBN().equals(data.getISBN())) {
                System.out.println("UPDATING DATA:" + book.toString());
                book.setTitle(data.getTitle());
                // todo: update other attributes
                int delta = data.getNoOfCopies() - book.getNoOfCopies();
                if (delta > 0) {
                    for (int i = 0; i < delta; i++) {
                        book.addBookCopy(new BookCopy());
                        System.out.println("UPDATING DATA:" + book.toString());
                    }
                }

                return write(list);
            }
        }
        return false;
    }
}
