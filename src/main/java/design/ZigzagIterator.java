package design;

import java.util.*;

/**
 * @author : Alexander Serebriyan
 */
public class ZigzagIterator {

    Queue<Iterator<Integer>> chain = new LinkedList<>();
    Iterator<Integer> current;

    public static void main(String[] args) {
        new ZigzagIterator(new ArrayList<>(), new ArrayList<>());

    }


    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        chain.add(v1.iterator());
        chain.add(v2.iterator());

        moveNext();
    }

    public int next() {
        final Integer res = current.next();

        if(current.hasNext()) {
            chain.add(current);
        }

        moveNext();

        return res;
    }

    private void moveNext() {
        current = null;
        while (current == null && chain.size() > 0) {
            current = chain.poll();
            if(!current.hasNext()) {
                current = null;
            }
        }
    }

    public boolean hasNext() {
        return current != null && current.hasNext();
    }
}
