/**
 * Runtime Complexity Linearithmic, O(nlogn).
 * 
 * Memory Complexity Logarithmic, O(logn).
 */
class Solution {
    // Below partition is using Hoare's algorithm.
    static int partition(int[] arr, int low, int high) {
        int pivot_value = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivot_value)
                i++;
            while (arr[j] > pivot_value)
                j--;

            if (i < j) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivot_value;

        // return the pivot index
        return j;
    }

    static void quick_sort_rec(int[] arr, int low, int high) {
        if (high > low) {
            int pivot_index = partition(arr, low, high);

            quick_sort_rec(arr, low, pivot_index - 1);
            quick_sort_rec(arr, pivot_index + 1, high);
        }
    }

    static void quick_sort(int[] arr) {
        quick_sort_rec(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[] { 33, 6, 21, 12, 19, 29, 38, 22, 14, 40 };
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();
        quick_sort(a);
        System.out.println();
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}