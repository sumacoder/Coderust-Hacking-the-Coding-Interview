/**
 * Runtime Complexity Logarithmic, O(logn).
 * 
 * Memory Complexity Constant, O(1).
 */
class Solution2 {
    // a is sorted array
    static int binSearch(int[] a, int key) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100 };
        System.out.println("Key(12) found at: " + binSearch(arr1, 12));
        System.out.println("Key(44) found at: " + binSearch(arr1, 44));
        System.out.println("Key(80) found at: " + binSearch(arr1, 80));
    }
}