
import java.util.*;

public class PersonDao implements Dao<Person> {

    public final static String FILENAME = "person.ser";

    Serializer<List<Person>> serializer = new Serializer<>();

    @Override
    public List<Person> read() {
        return serializer.deSerialize(FILENAME);
    }

    @Override
    public boolean write(List<Person> list) {
        return serializer.serialize(list, FILENAME);
    }

}
