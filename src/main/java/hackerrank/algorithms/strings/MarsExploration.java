package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by ekefar on 3/30/17.
 * <p>
 * https://www.hackerrank.com/challenges/mars-exploration
 * <p>
 * Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string, , determine how many letters of Sami's SOS have been changed by radiation.
 * <p>
 * Input Format
 * <p>
 * There is one line of input: a single string, .
 * <p>
 * Note: As the original message is just SOS repeated  times, 's length will be a multiple of .
 * <p>
 * Constraints
 * <p>
 * will contain only uppercase English letters.
 * Output Format
 * <p>
 * Print the number of letters in Sami's message that were altered by cosmic radiation.
 * <p>
 * Sample Input 0
 * <p>
 * SOSSPSSQSSOR
 * Sample Output 0
 * <p>
 * 3
 * Sample Input 1
 * <p>
 * SOSSOT
 * Sample Output 1
 * <p>
 * 1
 * Explanation
 * <p>
 * Sample 0
 * <p>
 * = SOSSPSSQSSOR, and signal length . Sami sent  SOS messages (i.e.: ).
 * <p>
 * Expected signal: SOSSOSSOSSOS
 * Recieved signal: SOSSPSSQSSOR
 * <p>
 * We print the number of changed letters, which is .
 * <p>
 * Sample 1
 * <p>
 * = SOSSOT, and signal length . Sami sent  SOS messages (i.e.: ).
 * <p>
 * Expected Signal: SOSSOS
 * Received Signal: SOSSOT
 * <p>
 * We print the number of changed letters, which is .
 */

public class MarsExploration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
    
        final char[] chars = input.toCharArray();

        int count = 0;
        for (int i = 0; i < chars.length; i++) {

            if ((i + 1) % 3 == 0) {
                if (chars[i] != 'S') {
                    count++;
                }
                if (chars[i - 1] != 'O') {
                    count++;
                }
                if (chars[i - 2] != 'S') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
