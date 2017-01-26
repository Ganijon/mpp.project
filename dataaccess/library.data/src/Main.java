
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<CheckoutRecord> list = new ArrayList<>();
        CheckoutEntry[] checkouts = {
            new CheckoutEntry(LocalDate.now(), LocalDate.now(), 0),
            new CheckoutEntry(LocalDate.now(), LocalDate.now(), 1),
            new CheckoutEntry(LocalDate.now(), LocalDate.now(), 2)};

        FineEntry[] fines = {
            new FineEntry(LocalDate.now(), LocalDate.now()),
            new FineEntry(LocalDate.now(), LocalDate.now()),
            new FineEntry(LocalDate.now(), LocalDate.now())};

        CheckoutRecord cr = new CheckoutRecord(0);
        list.add(cr);

        CheckoutRecordDao dao = new CheckoutRecordDao();

        dao.add(cr);
        
        boolean success = dao.write(list);

        System.out.println(success ? "success" : "error");

        List<CheckoutRecord> readList = dao.read();

        System.out.println(readList);

        dao.add(cr);

        System.out.println(dao.read());
    }
}
