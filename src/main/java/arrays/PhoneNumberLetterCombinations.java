package arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class PhoneNumberLetterCombinations {


    public static void main(String[] args) {

        final List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<>();
        }

        final HashMap<Character, String[]> characterHashMap = prepareDigitsLettersMap();

        List<String> combinations = new LinkedList<>();
        Collections.addAll(combinations, characterHashMap.get(digits.charAt(0)));

        char[] charArray = digits.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            char c = charArray[i];
            final String[] letters = characterHashMap.get(c);

            final List<String> newCombinations = new LinkedList<>();
            for (String combination : combinations) {
                for (String letter : letters) {
                    newCombinations.add(combination + letter);
                }
            }
            combinations = newCombinations;
        }

        return combinations;
    }

    private static HashMap<Character, String[]> prepareDigitsLettersMap() {
        final HashMap<Character, String[]> digitsToLetters = new HashMap<>();
        digitsToLetters.put('0', new String[]{" "});
        digitsToLetters.put('2', new String[]{"a", "b", "c"});
        digitsToLetters.put('3', new String[]{"d", "e", "f"});
        digitsToLetters.put('4', new String[]{"g", "h", "i"});
        digitsToLetters.put('5', new String[]{"j", "k", "l"});
        digitsToLetters.put('6', new String[]{"m", "n", "o"});
        digitsToLetters.put('7', new String[]{"p", "q", "r", "s"});
        digitsToLetters.put('8', new String[]{"t", "u", "v"});
        digitsToLetters.put('9', new String[]{"w", "x", "y", "z"});

        return digitsToLetters;
    }


}
