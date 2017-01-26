
import java.util.List;

public class BookDao implements Dao<Book> {

    public final static String FILENAME = "books.ser";

    Serializer<List<Book>> serializer = new Serializer<>();

    @Override
    public List<Book> read() {
        return serializer.deSerialize(FILENAME);
    }

    @Override
    public boolean write(List<Book> list) {
        return serializer.serialize(list, FILENAME);
    }

    @Override
    public boolean add(Book newBook) {
        List<Book> allBooks = read();
        allBooks.add(newBook);
        return write(allBooks);
    }

}

