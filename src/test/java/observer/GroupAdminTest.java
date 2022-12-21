package observer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.register(concreteMember);
        ArrayList<Member> cotumers = new ArrayList<>();
        cotumers.add(concreteMember);
        assertEquals(groupAdmin.cotumers,cotumers);

    }

    @Test
    void unregister() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.unregister(concreteMember);
        ArrayList<Member> cotumers = new ArrayList<>();
        cotumers.add(concreteMember);
        cotumers.remove(concreteMember);
        assertEquals(groupAdmin.cotumers,cotumers);
    }

    @Test
    void insert() {
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.append("hello");
        groupAdmin.insert(1,"hy");
        GroupAdmin groupAdmin1 = new GroupAdmin();
        groupAdmin1.append("hhyello");
        assertEquals(groupAdmin.toString(),groupAdmin1.toString());
    }

    @Test
    void append() {
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.append("hello");
        assertEquals(groupAdmin.undoableStringBuilder.toString(),"hello");
    }

    @Test
    void delete() {
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.append("hello");
        groupAdmin.delete(-1,3);
        assertEquals(groupAdmin.undoableStringBuilder.toString(),"hello");
//        groupAdmin.delete(1,3);
//        assertEquals(groupAdmin.undoableStringBuilder.toString(),"hlo");

    }

    @Test
    void undo() {
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.append("hello");
        groupAdmin.undo();
        assertEquals("",groupAdmin.undoableStringBuilder.toString());
    }
}