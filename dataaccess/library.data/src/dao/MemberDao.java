package dao;

import io.Serializer;
import entity.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberDao implements Dao<Member> {

    private final static String FILENAME = "members.ser";

    private final Serializer<List<Member>> serializer;

    public MemberDao() {
        this.serializer = new Serializer<>();
    }

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
        newMember.setMemberId(Integer.toString(list.size() + 1));
        list.add(newMember);
        return write(list);
    }

    //@Override
    public Member find(String memberId) {
        List<Member> list = read();
        for (Member member : list) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public boolean update(Member data) {
        List<Member> list = read();
        for (Member member : list) {
            if (member.getMemberId().equals(data.getMemberId())) {
                member = data;
            }
            return write(list);
        }
        return false;
    }
}
