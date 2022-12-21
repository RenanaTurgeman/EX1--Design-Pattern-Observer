package observer;

public class ConcreteMember implements Member{
    UndoableStringBuilder undoableStringBuilder;

    /**
     *this method responsible to update the observers  about the action that happen
     * @param usb- the action that happen
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        undoableStringBuilder = usb;
    }

    @Override
    public String toString() {
        return "ConcreteMember{" +
                "undoableStringBuilder=" + undoableStringBuilder +
                '}';
    }
}
