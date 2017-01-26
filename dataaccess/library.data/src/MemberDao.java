
import java.util.ArrayList;
import java.util.List;

public class MemberDao implements Dao<Member> {

    public final static String FILENAME = "members.ser";

    Serializer<List<Member>> serializer = new Serializer<>();

    @Override
    public List<Member> read() {
        List<Member> list = serializer.deSerialize(FILENAME);
        if (list == null) {
            write(new ArrayList<>());
            list = read();
        }
        return list;
    }

    @Override
    public boolean write(List<Member> list) {
        return serializer.serialize(list, FILENAME);
    }

    @Override
    public boolean add(Member newMember) {
        List<Member> list = read();
        newMember.setMemberID(list.size() + 1);
        list.add(newMember);
        return write(list);
    }

    //@Override
    public Member find(int memberId) {
        List<Member> list = read();
        for (Member member : list) {
            if (member.getMemberID() == memberId) {
                return member;
            }
        }
        return null;
    }

}
