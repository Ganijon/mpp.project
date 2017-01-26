
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        Book b = new Book("Fifty Shades of Grey", "ABCD-1234-555", 7, new BookCopy());
        list.add(b);

        BookDao dao = new BookDao();

        boolean success = dao.write(list);

        System.out.println(success ? "success" : "error");

        List<Book> readList = dao.read();

        System.out.println(readList);

        dao.add(b);
        
        System.out.println(dao.read());
        /*
        
        DataAccess da = DataAccessFactory.getDataAccess();
        

        Dao dao = new PersonDao(list);

        try {
            da.write(dao);
            
        } catch (IOException e) {
            //handle
        }
         
        Dao dao2 = new PersonDao();
        try {
            da.read(dao2);
            List<Person> persons = (List<Person>) dao2.getResults();

            for (Person p : persons) {
                System.out.println(p);
            }
            //display addresses
        } catch (IOException e) {
            //handle
        }
         */
    }
}
