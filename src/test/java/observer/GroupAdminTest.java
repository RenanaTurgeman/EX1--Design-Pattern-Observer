package observer;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {
    public static final Logger logger = LoggerFactory.getLogger(GroupAdminTest.class);
    @Test
    void register() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.register(concreteMember);
        logger.info(()->JvmUtilities.objectTotalSize(groupAdmin));
        ArrayList<Member> costumers = new ArrayList<>();
        costumers.add(concreteMember);
        assertEquals(groupAdmin.costumers,costumers);

    }

    @Test
    void unregister() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember concreteMember = new ConcreteMember();
        groupAdmin.unregister(concreteMember);
        logger.info(()->JvmUtilities.objectTotalSize(groupAdmin));
        ArrayList<Member> cotumers = new ArrayList<>();
        cotumers.add(concreteMember);
        cotumers.remove(concreteMember);
        assertEquals(groupAdmin.costumers,cotumers);
    }

    @Test
    void insert() {
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.append("hello");
        groupAdmin.insert(1,"hy");
        GroupAdmin groupAdmin1 = new GroupAdmin();
        groupAdmin1.append("hhyello");
        assertEquals(groupAdmin.toString(),groupAdmin1.toString());

        GroupAdmin groupAdmin2 = new GroupAdmin();
        groupAdmin2.append("hello");
        groupAdmin.insert(-1,"hy");
        //we expect to get an error message from try & catch
        assertEquals(groupAdmin2.undoableStringBuilder.toString(),"hello");

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
        //we expect to get an error message from try & catch
        assertEquals(groupAdmin.undoableStringBuilder.toString(),"hello");
        groupAdmin.delete(1,3);
        assertEquals(groupAdmin.undoableStringBuilder.toString(),"hlo");

    }

    @Test
    void undo() {
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.append("hello");
        groupAdmin.undo();
        assertEquals("",groupAdmin.undoableStringBuilder.toString());
    }
}