package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Alexander Serebriyan
 */
public class AllPermutations {

    public static void main(String[] args) {
        System.out.println(permutations("abcd"));
    }

    public static Set permutations(String s) {
        Set<String> permutations = new HashSet<>();
        for(char c : s.toCharArray()) {
            Set<String> newPermutations = new HashSet<>();
            for(String perm : permutations) {
                for(int i=0;i<=perm.length();i++) {
                    String start = perm.substring(0, i);
                    String end = perm.substring(i, perm.length());
                    String newPerm = start + c + end;
                    newPermutations.add(newPerm);
                }
            }

            if(newPermutations.isEmpty()) {
                permutations.add(String.valueOf(c));
                continue;
            }

            permutations = newPermutations;
        }

        return permutations;
    }

}
