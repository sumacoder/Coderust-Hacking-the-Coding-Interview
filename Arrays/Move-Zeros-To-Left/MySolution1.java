
/**
 * Runtime Complexity
Linear, O(n).

Memory Complexity
Constant, O(1).
 */
import java.util.*;

class MySolution1 {
    static void move_zeros_to_left_in_array(int[] A) {
        if (A.length == 0 || A == null) {
            return;
        }
        int size = A.length;
        int read = size - 1;
        int write = size - 1;

        while (read >= 0) {
            if (A[read] != 0) {
                A[write] = A[read];
                write--;
            }
            read--;
        }
        while (write >= 0) {
            A[write] = 0;
            write--;
        }
    }

    public static void main(String[] args) {
        int[] v = new int[] { 1, 10, -1, 11, 5, 0, -7, 0, 25, -35 };
        System.out.println("Original Array: " + Arrays.toString(v));
        move_zeros_to_left_in_array(v);
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + ", ");
        }
    }
}