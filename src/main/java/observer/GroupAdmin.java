package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
     ArrayList<Member> cotumers;
    UndoableStringBuilder undoableStringBuilder;
    public GroupAdmin(){
        this.cotumers = new ArrayList<>();
        this.undoableStringBuilder = new UndoableStringBuilder();
    }

    @Override
    public void register(Member obj) {
        if(!cotumers.contains(obj)){
        this.cotumers.add(obj);
        }
    }

    @Override
    public void unregister(Member obj) {
        if(cotumers.contains(obj)){
            this.cotumers.remove(obj);
        }
    }

    @Override
    public void insert(int offset, String obj) {
        undoableStringBuilder.insert(offset,obj);
        //maby update?
    }

    @Override
    public void append(String obj) {
        undoableStringBuilder.append(obj);
    }

    @Override
    public void delete(int start, int end) {
        undoableStringBuilder.delete(start,end);
    }

    @Override
    public void undo() {
        undoableStringBuilder.undo();
    }


    @Override
    public String toString() {
        return "GroupAdmin{" +
                "cotumers=" + cotumers +
                ", undoableStringBuilder=" + undoableStringBuilder +
                '}';
    }
}
