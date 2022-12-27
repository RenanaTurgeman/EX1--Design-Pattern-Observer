package observer;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * A class that we could use it to do undo for certain functions from StringBuilder class
 *
 * @author Renana Turgeman and Ofir Shitrit
 * @version 1.10 06 November 2022
 */

public class UndoableStringBuilder {
    Stack<String> states;
    StringBuilder sb;


    public UndoableStringBuilder() {
        states = new Stack<>();
        sb = new StringBuilder();

    }


    /**
     * This method appends the mentioned string with the existing string.
     *
     * @param string - the string that we want append
     * @return the two strings that connect
     */
    UndoableStringBuilder append(String string) {
        this.states.push(sb.toString());
        this.sb.append(string);
        return this;
    }

    /**
     * This method will delete the string from the mentioned start index till the end index.
     *
     * @param start - the start index of the string we want to delete.
     * @param end   - the end index of the string we want to delete.
     * @return the original string without the substring we delete
     */
    UndoableStringBuilder delete(int start, int end) {
        try {
            this.states.push(sb.toString());
            this.sb.delete(start, end);
        } catch (StringIndexOutOfBoundsException error) {
            System.err.println("There is a problem, please check the bounds");
        }
        return this;
    }

    /**
     * It will insert the mentioned string to the other string from the specified offset position.
     *
     * @param offset - the position we want to insert the new string
     * @param s      - the string we want to insert
     * @return the original string with the s string inside it.
     * this.sb.delete(start, end);
     */
    UndoableStringBuilder insert(int offset, String s) {
        try {
            this.states.push(sb.toString());
            this.sb.insert(offset, s);
        } catch (StringIndexOutOfBoundsException error) {
            System.err.println("There is a problem, please check the bounds");
        }
        return this;
    }

    /**
     * It will reverse the string.
     *
     * @return the reverse string
     */
    UndoableStringBuilder reverse() {
        this.states.push(sb.toString());
        this.sb.reverse();
        return this;
    }

    /**
     * It will replace the original string with the specified string
     * from the start index till the end index.
     *
     * @param start the first index that from it we change the characters
     * @param end   the last index that until it we change the characters
     * @param s     the string we want to replace with the substring from start to end
     * @return the original string with the s string that replaced substring
     */
    UndoableStringBuilder replace(int start, int end, String s) {
        try {
            this.states.push(sb.toString());
            this.sb.replace(start, end, s);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("There is a problem, please check the bounds");
        } catch (NullPointerException e) {
            System.err.println("There is a problem, please check if the string is not null");
        }
        return this;
    }

    /**
     * undo the last action
     */
    public void undo() {
        try {
            sb = new StringBuilder(this.states.pop());
        } catch (EmptyStackException e) {
            sb = new StringBuilder();
        }
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
