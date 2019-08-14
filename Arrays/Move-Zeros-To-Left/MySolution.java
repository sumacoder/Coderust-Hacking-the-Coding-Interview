import java.util.*;

class MySolution {
    static void move_zeros_to_left_in_array(int[] A) {
        if (A.length == 0 || A == null) {
            return;
        }
        int count = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                count++;
            } else {
                l.add(A[i]);
            }
        }
        for (int i = 0; i < count; i++) {
            A[i] = 0;
        }
        for (int n : l) {
            A[count++] = n;
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