
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        //list.add(new Person("Alice", "111"));
        list.add(new Person("Bob", "222"));
        list.add(new Person("Cathy", "333"));
        list.add(new Person("Dave", "444"));
        list.add(new Person("Elen", "555"));

        PersonDao personDao = new PersonDao();

        boolean success = personDao.write(list);

        System.out.println(success ? "success" : "error");

        List<Person> readList = personDao.read();

        System.out.println(readList);

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
