import java.util.*;

class Solution {
    static int find_low_index(List<Integer> arr, int key) {

        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;

        while (low <= high) {

            int mid_elem = arr.get(mid);

            if (mid_elem < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if (low < arr.size() && arr.get(low) == key) {
            return low;
        }

        return -1;
    }

    static int find_high_index(List<Integer> arr, int key) {

        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;

        while (low <= high) {

            int mid_elem = arr.get(mid);

            if (mid_elem <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if (high == -1) {
            return high;
        }

        if (high < arr.size() && arr.get(high) == key) {
            return high;
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 7, 7, 8, 8, 10);
        int key = 8;
        int low = find_low_index(array, key);
        int high = find_high_index(array, key);
        System.out.println("LowIndex of " + key + " : " + low);
        System.out.println("HighIndex of " + key + " : " + high);

        key = -2;
        low = find_low_index(array, key);
        high = find_high_index(array, key);
        System.out.println("LowIndex of " + key + " : " + low);
        System.out.println("HighIndex of " + key + " : " + high);
    }
}