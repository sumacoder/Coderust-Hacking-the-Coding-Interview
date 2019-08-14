
/**
 * Runtime Complexity
Linear, O(n).

Memory Complexity
Linear, O(n).
 */
import java.util.*;

// find_sum_of_two function return true if
// there are two values in array who
// sum to value and returns false otherwise
class MySolution {
    static boolean find_sum_of_two(int[] A, int val) {
        if (A.length == 0 || A == null) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.contains(val - A[i])) {
                return true;
            }
        }

        return false;
    }

    static void test(int[] v, int val) {
        boolean output = find_sum_of_two(v, val);
        System.out.println("exist(A, " + val + ") = " + (output ? "true" : "false") + "\n");
    }

    public static void main(String[] args) {
        int[] v = new int[] { 2, 1, 8, 4, 7, 3 };
        test(v, 3);
        test(v, 20);
        test(v, 1);
        test(v, 2);
        test(v, 7);
    }
}