package general;

import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * @author : Alexander Serebriyan
 *
 * https://leetcode.com/problems/next-closest-time/description/
 *
 *         <p>
 *         Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 *         There is no limit on how many times a digit can be reused.
 *         <p>
 *         You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid.
 *         "1:34", "12:9" are all invalid.
 *         <p>
 *         Example 1:
 *         <p>
 *         Input: "19:34"
 *         Output: "19:39"
 *         Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
 *         It is not 19:33, because this occurs 23 hours and 59 minutes later.
 *         Example 2:
 *         <p>
 *         Input: "23:59"
 *         Output: "22:22"
 *         Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 *         It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 *
 *
 */
public class NextClosestTime {

    public static void main(String[] args) {
        System.out.println(nextClosestTime("11:19"));
    }

    public static String nextClosestTime(String time) {
        final String[] split = time.split(":");
        final String hour = split[0];
        final String minute = split[1];

        final LinkedList<String> hours = new LinkedList<>();
        final LinkedList<String> minutes = new LinkedList<>();

        for (int i = 0; i < 24; i++) {
            hours.add(addLeadingZeroIfNeeded(i));
        }

        for (int i = 0; i < 60; i++) {
            minutes.add(addLeadingZeroIfNeeded(i));
        }

        final Set<String> availableDigits = parseAvailableDigits(hour, minute);

        final String nextMinute = nextNumber(minute, minutes, availableDigits);

        String nextHour = hour;
        if (parseInt(nextMinute) < parseInt(minute)) {
            nextHour = nextNumber(hour, hours, availableDigits);
        }

        return nextHour + ":" + nextMinute;
    }

    public static String addLeadingZeroIfNeeded(Integer number) {
        if (number < 10) {
            return "0" + number;
        }

        return number.toString();
    }

    public static String nextNumber(String number, LinkedList<String> numbers, Set<String> availableDigits) {
        String prev = "";
        String next = "";
        for (String num : numbers) {
            final String[] split = num.split("");
            final String lead = split[0];
            final String trail = split[1];

            if (parseInt(num) < parseInt(number) &&
                    "".equals(prev) &&
                    availableDigits.contains(lead) &&
                    availableDigits.contains(trail)) {
                prev = num;
                continue;
            }

            if (parseInt(num) > parseInt(number) &&
                    "".equals(next)
                    && availableDigits.contains(lead)
                    && availableDigits.contains(trail)) {
                next = num;
                break;
            }
        }


        if("".equals(next) && "".equals(prev)) {
            return number;
        }
        return !"".equals(next) ? next : prev;
    }

    public static Set<String> parseAvailableDigits(String hour, String minute) {
        final Set<String> availableDigits = new HashSet<>();

        availableDigits.addAll(Arrays.asList(hour.split("")));
        availableDigits.addAll(Arrays.asList(minute.split("")));
        return availableDigits;
    }
}
