package dao;

import io.Serializer;
import model.CheckoutEntry;
import model.Checkout;
import java.util.ArrayList;
import java.util.List;

public final class CheckoutDao implements Dao<Checkout> {

    private final static String FILENAME = "checkouts.ser";

    private final Serializer<List<Checkout>> serializer;

    public CheckoutDao() {
        this.serializer = new Serializer<>();
    }

    @Override
    public List<Checkout> read() {
        List<Checkout> list = serializer.deSerialize(FILENAME);
        if (list == null) {
            write(new ArrayList<>());
            list = read();
        }
        return list;
    }

    @Override
    public boolean write(List<Checkout> list) {
        return serializer.serialize(list, FILENAME);
    }

    @Override
    public boolean add(Checkout newRecord) {
        List<Checkout> list = read();
        list.add(newRecord);
        return write(list);
    }

    @Override
    public Checkout find(String memberId) {
        List<Checkout> list = read();
        for (Checkout record : list) {
            if (record.getMemberId().equals(memberId)) {
                return record;
            }
        }
        return null;
    }

    @Override
    public boolean update(Checkout data) {
        List<Checkout> list = read();
        for (Checkout record : list) {
            if (record.getMemberId().equals(data.getMemberId())) {
                record.getCheckouts().clear();
                for (CheckoutEntry e : data.getCheckouts()) {
                    record.getCheckouts().add(e);
                }
            }
        }
        return write(list);
    }

}
