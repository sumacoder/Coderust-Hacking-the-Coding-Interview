/**
 * Runtime Complexity The runtime complexity of the code is Linear, O(n).
 * 
 * Memory Complexity The memory complexity of the code is Constant, O(1).
 */
class rotateArray {
    static void reverse_array(List<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            ++start;
            --end;
        }
    }

    static void rotate_array_in_place(List<Integer> arr, int n) {

        int len = arr.size();
        // Let's normalize rotations
        // if n > array size or n is negative.
        n = n % len;
        if (n < 0) {
            // calculate the positive rotations needed.
            n = n + len;
        }

        // Let's partition the array based on rotations 'n'.
        // For example: 1, 2, 3, 4, 5 where n = 2.
        // -> 5, 4, 3, 2, 1
        // -> 4, 5, 3, 2, 1
        // -> 4, 5, 1, 2, 3

        reverse_array(arr, 0, len - 1);
        reverse_array(arr, 0, n - 1);
        reverse_array(arr, n, len - 1);
    }

    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Array Before Rotation\n" + v1);
        rotate_array_in_place(v1, 2);
        System.out.println("Array After Rotation\n" + v1);
    }
}