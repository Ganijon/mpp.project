package dao;

import io.Serializer;
import model.Book;
import java.util.ArrayList;
import java.util.List;

public final class BookDao implements Dao<Book> {

    private final static String FILENAME = "books.ser";

    private final Serializer<List<Book>> serializer;

    public BookDao() {
        this.serializer = new Serializer<>();
    }

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

    @Override
    public boolean update(Book data) {
        List<Book> list = read();
        for (Book book : list) {
            if (book.getISBN().equals(data.getISBN())) {
                book.setTitle(data.getTitle());
                book.setBookCopies(data.getBookCopies());

                return write(list);
            }
        }
        return false;
    }
}
