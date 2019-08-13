class Solution {
    static int findPivot(int[] arr, int left, int right) {
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (arr[pivot] > arr[pivot + 1]) {
                return pivot;
            } else if (arr[pivot] > arr[left]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    static int binary_search(int[] arr, int st, int end, int key) {
        if (st > end) {
            return -1;
        }
        int mid = st + (end - st) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return binary_search(arr, mid + 1, end, key);
        } else {
            return binary_search(arr, st, mid - 1, key);
        }
    }

    static int binary_search_rotated(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length - 1;
        int pivot = findPivot(arr, 0, n);
        if (pivot == 0) {
            return binary_search(arr, 0, n, key);
        } else if (arr[0] <= key) {
            return binary_search(arr, 0, pivot, key);
        } else {
            return binary_search(arr, pivot + 1, n, key);
        }
    }

    public static void main(String[] args) {
        int[] v1 = { 6, 7, 1, 2, 3, 4, 5 };
        System.out.println("Key(3) found at: " + binary_search_rotated(v1, 3));
        System.out.println("Key(6) found at: " + binary_search_rotated(v1, 6));
        int[] v2 = { 4, 5, 6, 1, 2, 3 };
        System.out.println("Key(3) found at: " + binary_search_rotated(v2, 3));
        System.out.println("Key(6) found at: " + binary_search_rotated(v2, 6));
        System.out.println("Key(2) found at: " + binary_search_rotated(v2, 2));
        int[] v3 = { 1, 2, 3, 4 };
        System.out.println("Key(1) found at: " + binary_search_rotated(v3, 1));

    }
}