package general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Alexander Serebriyan
 *         <p>
 *         https://leetcode.com/problems/moving-average-from-data-stream/
 *         <p>
 *         Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *         <p>
 *         For example,
 *         MovingAverage m = new MovingAverage(3);
 *         m.next(1) = 1
 *         m.next(10) = (1 + 10) / 2
 *         m.next(3) = (1 + 10 + 3) / 3
 *         m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage {

    public static void main(String[] args) {
        final MovingAverage movingAverage = new MovingAverage(2);

        System.out.println(movingAverage.next(2));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(4));
        System.out.println(movingAverage.next(5));
        System.out.println(movingAverage.next(6));
    }

    int size;
    double sum = 0;
    Queue<Integer> queue = new LinkedList<>();


    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        sum += val;
        if (queue.size() > size) {
            sum -= queue.poll();
        }
        return sum / queue.size();
    }
}
