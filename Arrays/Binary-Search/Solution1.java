/**
 * Runtime Complexity Logarithmic, O(logn).
 * 
 * Memory Complexity Logarithmic, O(logn).
 */

class Solution1 {
    static int binarySearch(int[] a, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (a[mid] == key) {
            return mid;
        } else if (a[mid] > key) {
            return binarySearch(a, low, mid - 1, key);
        } else {
            return binarySearch(a, mid + 1, high, key);
        }
    }

    static int binSearch(int[] a, int key) {
        return binarySearch(a, 0, a.length - 1, key);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100 };
        System.out.println("Key(12) found at: " + binSearch(arr1, 12));
        System.out.println("Key(44) found at: " + binSearch(arr1, 44));
        System.out.println("Key(80) found at: " + binSearch(arr1, 80));
    }
}