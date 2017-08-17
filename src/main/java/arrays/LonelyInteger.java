package arrays;

import java.util.HashMap;

/**
 * @author : Alexander Serebriyan
 */
public class LonelyInteger {

    public static void main(String[] args) {
        final int[] ints = {1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6};
        System.out.println(lonelyInteger(ints));
    }

    public static int lonelyInteger(int[] a) {
        final HashMap<Integer, Boolean> presenceMap = new HashMap<>();

        for (int number : a) {
            if(presenceMap.containsKey(number)) {
                presenceMap.remove(number);
            } else {
                presenceMap.put(number, true);
            }
        }

        return presenceMap.keySet().iterator().next();
    }
}
