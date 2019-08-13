import java.util.*;

class MySolution {
    static void rotate_array(List<Integer> arr, int n) {
        if (arr == null || n > arr.size()) {
            return;
        }
        int last;
        int size = arr.size();
        while (n-- > 0) {
            last = arr.get(size - 1);
            for (int i = size - 1; i > 0; i--) {
                arr.set(i, arr.get(i - 1));
            }
            arr.set(0, last);
        }
    }

    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Array Before Rotation\n" + v1);
        rotate_array(v1, 2);
        System.out.println("Array After Rotation\n" + v1);
    }
}