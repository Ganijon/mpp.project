
import java.util.ArrayList;
import java.util.List;

public class MemberDao implements Dao<Member> {

    public final static String FILENAME = "members.ser";

    Serializer<List<Member>> serializer = new Serializer<>();

    @Override
    public List<Member> read() {
        return serializer.deSerialize(FILENAME);
    }

    @Override
    public boolean write(List<Member> list) {
        return serializer.serialize(list, FILENAME);
    }

    @Override
    public boolean add(Member newMember) {
        List<Member> list;
        
        // check data file
        list = read();
        if (list == null) {
            // create empty data file
            write(new ArrayList<>());
            list = read();
        }
        
        newMember.setMemberID(list.size() + 1);
        list.add(newMember);
        
        return write(list);
    }

}
