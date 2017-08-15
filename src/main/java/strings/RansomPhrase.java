package strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : Alexander Serebriyan
 * https://www.hackerrank.com/challenges/ctci-ransom-note
 */
public class RansomPhrase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        final HashMap<String, Integer> wordsMap = new HashMap<>();

        for (String word : magazine) {
            if(wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) +1);
                continue;
            }
            wordsMap.put(word, 1);
        }

        for (String word : ransom) {
            if (!wordsMap.containsKey(word) || wordsMap.get(word) == 0) {
                System.out.println("No");
                System.exit(0);
            } else {
                wordsMap.put(word, wordsMap.get(word) - 1);
            }
        }

        System.out.println("Yes");
    }
}
