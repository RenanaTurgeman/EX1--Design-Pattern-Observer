package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
     ArrayList<Member> costumers;
    UndoableStringBuilder undoableStringBuilder;

    //constructor
    public GroupAdmin(){
        this.costumers = new ArrayList<>();
        this.undoableStringBuilder = new UndoableStringBuilder();
    }

    /**
     * register the member obj - add it to the ArrayList costumer
     * @param obj - the member we register
     */
    @Override
    public void register(Member obj) {
        if(!costumers.contains(obj)){
            costumers.add(obj);
        }
        notifyObservers();
    }

    /**
     * unregister the member obj - remove obj from the ArrayList costumer
     * @param obj- the member we unregister
     */
    @Override
    public void unregister(Member obj) {
        if(costumers.contains(obj)){
            costumers.remove(obj);
        }
        notifyObservers();
    }

    /**
     *  the function inserts the string into this character sequence.
     * @param offset - the position where we insert the string
     * @param obj - the string we insert.
     */
    @Override
    public void insert(int offset, String obj) {
        undoableStringBuilder.insert(offset,obj);
        notifyObservers();
    }

    @Override
    public void append(String obj) {
        undoableStringBuilder.append(obj);
        notifyObservers();
    }

    /**
     *Removes the characters in a substring of this sequence.
     * @param start
     * @param end
     */
    @Override
    public void delete(int start, int end) {
        try {
            undoableStringBuilder.delete(start, end);
            notifyObservers();
        }
        catch (StringIndexOutOfBoundsException error) {
            System.err.println("StringIndexOutOfBoundsException");
        }
    }

    @Override
    public void undo() {
        undoableStringBuilder.undo();
        notifyObservers();
    }

    public void notifyObservers(){
        for(Member costumer : costumers){
            costumer.update(undoableStringBuilder);
        }
    }

    @Override
    public String toString() {
        return "GroupAdmin{" +
                "cotumers=" + costumers +
                ", undoableStringBuilder=" + undoableStringBuilder +
                '}';
    }
}
