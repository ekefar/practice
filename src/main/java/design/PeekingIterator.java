package design;

import java.util.Iterator;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/peeking-iterator/description/
 */
public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer peek;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek != null) {
            return peek;
        }

        peek = iterator.next();
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {

        if (peek != null) {
            Integer result = peek;
            peek = null;
            return result;
        }

        return iterator.next();

    }

    @Override
    public boolean hasNext() {
        if (peek != null) {
            return true;
        }

        return iterator.hasNext();
    }
}
