
import java.util.List;

public interface Dao <T> {

    List<T> read();
    boolean write(List<T> list);
    boolean add(T object);
    //T find(String key);
}
