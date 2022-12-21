package observer;

public class ConcreteMember implements Member{
    UndoableStringBuilder undoableStringBuilder;


    @Override
    public void update(UndoableStringBuilder usb) {
        this.undoableStringBuilder = usb;
    }

    @Override
    public String toString() {
        return "ConcreteMember{" +
                "undoableStringBuilder=" + undoableStringBuilder +
                '}';
    }
}
