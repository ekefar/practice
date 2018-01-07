package strings;

/**
 * @author : Alexander Serebriyan
 *         <p>
 *         Given two strings A and B, find the minimum number of times A has
 *         to be repeated such that B is a substring of it. If no such solution, return -1.
 *         <p>
 *         For example, with A = "abcd" and B = "cdabcdab".
 *         <p>
 *         Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it;
 *         and B is not a substring of A repeated two times ("abcdabcd").
 *         <p>
 *         Note:
 *         The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {

    public static void main(String[] args) {
        final String a = "abcd";
        final String b = "abcd";

        final int solution = repeatedStringMatch(a, b);
        System.out.println(solution);
    }

    public static int repeatedStringMatch(String a, String b) {

        final int minRepetitions = b.length() / a.length();

        final StringBuilder repetitionBuilder = new StringBuilder();
        for (int i = 0; i < minRepetitions; i++) {
            repetitionBuilder.append(a);
        }

        if (repetitionBuilder.toString().contains(b)) {
            return minRepetitions;
        }

        repetitionBuilder.append(a);

        if (repetitionBuilder.indexOf(b) != -1) {
            return minRepetitions + 1;
        }

        repetitionBuilder.append(a);

        if (repetitionBuilder.indexOf(b) != -1) {
            return minRepetitions + 2;
        }

        return -1;

    }
}
