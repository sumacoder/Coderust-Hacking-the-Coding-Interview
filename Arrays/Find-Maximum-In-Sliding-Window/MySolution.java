
/**
 * Missing boundry check: 1. arr is empty; 2 arr length is less than windowSize
 */
import java.util.*;

class MySolution {

    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {

        ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing max values
        for (int i = 0; i < arr.length - windowSize + 1; i++) {
            int j = i + windowSize;
            int max = arr[i];
            for (int k = i + 1; k < j; k++) {
                if (arr[k] > max) {
                    max = arr[k];
                }
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.print("Array = ");
        System.out.println(Arrays.toString(array));

        System.out.println("Max = " + findMaxSlidingWindow(array, 3));

        int[] array2 = { 10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67 };
        System.out.println("Array = " + Arrays.toString(array2));

        System.out.println("Max = " + findMaxSlidingWindow(array2, 3));
    }
}