/**
 * Runtime Complexity Logarithmic, O(logn).
 * 
 * Memory Complexity Logarithmic, O(logn).
 */
class Solution {

    public static int binary_search(int[] arr, int st, int end, int key) {
        // assuming all the keys are unique.

        if (st > end) {
            return -1;
        }

        int mid = st + (end - st) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[st] <= arr[mid] && key <= arr[mid] && key >= arr[st]) {
            return binary_search(arr, st, mid - 1, key);
        } else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
            return binary_search(arr, mid + 1, end, key);
        } else if (arr[end] <= arr[mid]) {
            return binary_search(arr, mid + 1, end, key);
        } else if (arr[st] >= arr[mid]) {
            return binary_search(arr, st, mid - 1, key);
        }

        return -1;
    }

    static int binary_search_rotated(int[] arr, int key) {
        return binary_search(arr, 0, arr.length - 1, key);
    }

    public static void main(String[] args) {
        int[] v1 = { 6, 7, 1, 2, 3, 4, 5 };
        System.out.println("Key(3) found at: " + binary_search_rotated(v1, 3));
        System.out.println("Key(6) found at: " + binary_search_rotated(v1, 6));
        int[] v2 = { 4, 5, 6, 1, 2, 3 };
        System.out.println("Key(3) found at: " + binary_search_rotated(v2, 3));
        System.out.println("Key(6) found at: " + binary_search_rotated(v2, 6));
    }
}