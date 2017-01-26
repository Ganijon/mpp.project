
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecordDao implements Dao<CheckoutRecord> {

    public final static String FILENAME = "checkoutrecords.ser";

    Serializer<List<CheckoutRecord>> serializer = new Serializer<>();

    @Override
    public List<CheckoutRecord> read() {
        return serializer.deSerialize(FILENAME);
    }

    @Override
    public boolean write(List<CheckoutRecord> list) {
        return serializer.serialize(list, FILENAME);
    }

    @Override
    public boolean add(CheckoutRecord newRecord) {
        List<CheckoutRecord> list = read();
        if (list == null) {
            write(new ArrayList<>());
            list = read();
        }
        list.add(newRecord);
        return write(list);
    }

}
