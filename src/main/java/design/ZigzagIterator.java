package design;

import java.util.*;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/zigzag-iterator/description/
 */
public class ZigzagIterator {

    Queue<Iterator<Integer>> chain = new LinkedList<>();
    Iterator<Integer> current;

    public static void main(String[] args) {
        final ArrayList<Integer> v1 = new ArrayList<>();
        v1.add(1);
        v1.add(2);

        final ArrayList<Integer> v2 = new ArrayList<>();
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        final ZigzagIterator iterator = new ZigzagIterator(v1, v2);

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }


    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (!v1.isEmpty()) {
            chain.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            chain.add(v2.iterator());
        }

        current = chain.poll();
    }

    public int next() {

        final Integer res = current.next();

        if (current.hasNext()) {
            chain.add(current);
        }

        current = chain.poll();
        return res;
    }


    public boolean hasNext() {
        return current != null && current.hasNext();
    }
}
