package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
        ConcreteMember concreteMember = new ConcreteMember();
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("hello");
        concreteMember.update(usb);
        UndoableStringBuilder undoableStringBuilder = new UndoableStringBuilder();
        undoableStringBuilder.append("hello");
        assertEquals(concreteMember.undoableStringBuilder.toString(),undoableStringBuilder);
    }
}