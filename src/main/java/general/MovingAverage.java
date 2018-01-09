package general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Alexander Serebriyan
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
