package general;

import java.util.HashMap;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInteger {

    final static HashMap<String, Integer> strToIntMap = new HashMap<>();

    static {

        strToIntMap.put("I", 1);
        strToIntMap.put("IV", 4);
        strToIntMap.put("V", 5);
        strToIntMap.put("IX", 9);
        strToIntMap.put("X", 10);
        strToIntMap.put("XL", 40);
        strToIntMap.put("L", 50);
        strToIntMap.put("XC", 90);
        strToIntMap.put("C", 100);
        strToIntMap.put("CD", 400);
        strToIntMap.put("D", 500);
        strToIntMap.put("CM", 900);
        strToIntMap.put("M", 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMIV"));
    }

    public static int romanToInt(String s) {

        int res = 0;
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final String currentChar = String.valueOf(chars[i]);
            if(i < chars.length -1) {

                final String possibleTwoDigit = currentChar + String.valueOf(chars[i + 1]);


                if(strToIntMap.containsKey(possibleTwoDigit) ) {
                    res += strToIntMap.get(possibleTwoDigit);
                    i++;
                } else {
                    res += strToIntMap.get(currentChar);
                }


            } else {
                res += strToIntMap.get(currentChar);
            }

        }

        return res;
    }

}
