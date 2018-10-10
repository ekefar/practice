package bit;

/**
 * @author : Alexander Serebriyan
 */
public class CountingBits {


    public static void main(String[] args) {
        int[] res = countBits(5);
        System.out.println(res);

    }

    public static int[] countBits(int num) {

        int[] results = new int[num+1];

        for (int i = 0; i <= num; i++) {

            String binaryString = Integer.toBinaryString(i);

            char[] chars = binaryString.toCharArray();
            for (char aChar : chars) {
                results[i] += aChar - '0';
            }

        }

        return results;

    }
}
