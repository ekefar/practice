package bit;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/add-binary/description/
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {


        StringBuilder result = new StringBuilder();
        int remainder = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {

            int aValue = i>=0? (a.charAt(i) - '0') :0;
            int bValue = j>=0? (b.charAt(j) - '0') :0;

            int current = aValue + bValue;

            result.append((current + remainder) %2);

            remainder = (current + remainder) / 2;

            i--;
            j--;
        }

        if(remainder != 0) {
            result.append(remainder);
        }

        return result.reverse().toString();
    }
}
