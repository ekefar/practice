package general;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class MergeIntervals {

    public static void main(String[] args) {
        LinkedList<Interval> intervals = new LinkedList<>();

        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        List<Interval> merge = merge(intervals);
        System.out.println(merge);
    }

    public static List<Interval> merge(List<Interval> intervals) {

        if(intervals.size() == 0) {
            return intervals;
        }

        Collections.sort(intervals, (o1, o2) -> o1.start > o2.start ? 1 : o1.start == o2.start ? 0: -1);

        LinkedList<Interval> result = new LinkedList<>();

        Interval previous = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(current.start <= previous.end){
                previous = new Interval(previous.start, Math.max(current.end, previous.end));
            } else {
                result.add(previous);
                previous = current;
            }
        }
        result.add(previous);

        return result;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }


        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
