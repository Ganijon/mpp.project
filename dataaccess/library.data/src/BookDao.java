
import java.util.ArrayList;
import java.util.List;

public class BookDao implements Dao<Book> {

    public final static String FILENAME = "books.ser";

    private Serializer<List<Book>> serializer = new Serializer<>();

    @Override
    public List<Book> read() {
        List<Book> list = serializer.deSerialize(FILENAME);
        if (list == null) {
            write(new ArrayList<>());
            list = read();
        }
        return list;
    }

    @Override
    public boolean write(List<Book> list) {
        return serializer.serialize(list, FILENAME);
    }

    @Override
    public boolean add(Book newBook) {
        List<Book> list = read();
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
                
                book.setTitle(data.getTitle());
                
                int delta = data.getNoOfCopies() - book.getNoOfCopies();
                if (delta > 0) {
                    for (int i = 0; i < delta; i++) {
                        book.addBookCopy(new BookCopy());
                    }
                }

                delta = book.getNoOfAvailableCopies() - data.getNoOfAvailableCopies();
                if (delta > 0) {
                    book.decrementNoOfAvailableCopies();
                }
                return write(list);
            }
        }
        return false;
    }
}
