package dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class WordBreak {

    public static void main(String[] args) {
        final ArrayList<String> dict = new ArrayList<>();
        dict.add("aaa");
        dict.add("aaaa");
        System.out.println(wordBreak("aaaaaaa", dict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        final HashMap<String, Integer> dict = new HashMap<>();

        for (String word : wordDict) {
            dict.put(word, 1);
        }

        final boolean[] checks = new boolean[s.length()+1];

        checks[0] = true;
        int lastCheck = 0;

        for(int i=0;i<s.length();i++ ) {

            String strToCheck = s.substring(lastCheck, i+1);

            if (dict.containsKey(strToCheck)) {
                checks[i+1]=true;
                lastCheck = i+1;
            } else {
                for(int j = lastCheck; j>=0 ; j--) {
                    if(checks[j]) {
                        strToCheck = s.substring(j, i+1);
                        if(dict.containsKey(strToCheck)) {
                            checks[i+1]=true;
                            lastCheck = i+1;
                            break;
                        }
                    }
                }
            }
        }

        return checks[s.length()];

    }
}
