
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecordDao implements Dao<CheckoutRecord> {

    public final static String FILENAME = "checkoutrecords.ser";

    Serializer<List<CheckoutRecord>> serializer = new Serializer<>();

    @Override
    public List<CheckoutRecord> read() {
        List<CheckoutRecord> list = serializer.deSerialize(FILENAME);
        if (list == null) {
            write(new ArrayList<>());
            list = read();
        }
        return list;
    }

    @Override
    public boolean write(List<CheckoutRecord> list) {
        return serializer.serialize(list, FILENAME);
    }

    @Override
    public boolean add(CheckoutRecord newRecord) {
        List<CheckoutRecord> list = read();
        list.add(newRecord);
        return write(list);
    }

    //@Override
    public CheckoutRecord find(int memberId) {
        List<CheckoutRecord> list = read();
        for (CheckoutRecord record : list) {
            if (record.getMemberId() == memberId) {
                return record;
            }
        }
        return null;
    }

    public boolean update(CheckoutRecord data) {
        List<CheckoutRecord> list = read();
        for (CheckoutRecord record : list) {
            if (record.getMemberId() == data.getMemberId()) {
                record.getCheckouts().clear();
                for (CheckoutEntry e : data.getCheckouts()) {
                    record.getCheckouts().add(e);
                }
            }
            return write(list);
        }
        return false;
    }

}
