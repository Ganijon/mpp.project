
import java.util.List;

public interface Dao <T> {

    public List<T> read();
    public boolean write(List<T> list);
    public boolean add(T object);
}
