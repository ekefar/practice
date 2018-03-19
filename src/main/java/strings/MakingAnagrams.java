package strings;

import java.util.*;

/**
 * @author : Alexander Serebriyan
 *         https://www.hackerrank.com/challenges/ctci-making-anagrams
 *
 *
 */
public class MakingAnagrams {

    public static int numberNeeded(String first, String second) {

        final HashMap<Character, Integer> firstStringChars = prepareCharsMap(first);
        final HashMap<Character, Integer> secondStringChars = prepareCharsMap(second);

        Set<Character> charSet = new HashSet<>(firstStringChars.keySet());
        charSet.addAll(secondStringChars.keySet());

        int numberNeeded = 0;

        for (Character character : charSet) {
            final Integer firstCount = firstStringChars.get(character);
            final Integer secondCount = secondStringChars.get(character);

            numberNeeded += firstCount != null && secondCount != null ? Math.abs(firstCount - secondCount) : 0;
            numberNeeded += firstCount == null && secondCount != null ? secondCount : 0;
            numberNeeded += firstCount != null && secondCount == null ? firstCount : 0;
        }

        return numberNeeded;
    }

//    another one
    private static boolean areAnagrams(String first, String second) {

        if(first.length() != second.length() || hash(first) != hash(second)) {
            return false;
        }

        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        Arrays.sort(firstChars);
        Arrays.sort(secondChars);

        return new String(firstChars).equals(new String(secondChars));
    }

    private static int hash(String str) {
        int hash = 0;
        for (char c : str.toCharArray()) {
            hash += c;
        }

        return hash;
    }

    // smart one
    /*public static int numberNeeded(String first, String second) {
        int[] lettercounts = new int[26];
        for (char c : first.toCharArray()) {
            lettercounts[c - 'a']++;
        }
        for (char c : second.toCharArray()) {
            lettercounts[c - 'a']--;
        }
        int result = 0;
        for (int i : lettercounts) {
            result += Math.abs(i);
        }
        return result;
    }*/

    private static HashMap<Character, Integer> prepareCharsMap(String first) {
        final HashMap<Character, Integer> firstStringChars = new HashMap<>();
        for (Character c : first.toCharArray()) {
            if (firstStringChars.containsKey(c)) {
                firstStringChars.put(c, firstStringChars.get(c) + 1);
                continue;
            }
            firstStringChars.put(c, 1);
        }
        return firstStringChars;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
