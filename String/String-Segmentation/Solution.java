
/**
 * Polynomial, O(n2).
 * 
 * Exponential, O(2n)
 */
import java.util.*;

class Solution {

    public static boolean can_segment_string(String s, Set<String> dict) {
        for (int i = 1; i <= s.length(); ++i) {
            String first = s.substring(0, i);
            if (dict.contains(first)) {
                String second = s.substring(i);

                if (second == null || second.length() == 0 || dict.contains(second)
                        || can_segment_string(second, dict)) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        String s = new String();
        s = "applepie";

        dict.add("pie");
        dict.add("pear");
        dict.add("apple");
        dict.add("peach");

        System.out.println("Result = " + can_segment_string(s, dict));
    }
}