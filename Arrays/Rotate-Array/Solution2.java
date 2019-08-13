/**
 * Runtime Complexity Linear, O(n).
 * 
 * Memory Complexity Linear, O(n).
 */
class rotateArray {
    static void rotate_array(List<Integer> arr, int n) {
        int len = arr.size();
        // Let's normalize rotations
        // if n > array size or n is negative.
        n = n % len;
        if (n < 0) {
            // calculate the positive rotations needed.
            n = n + len;
        }

        List<Integer> temp = Arrays.asList(new Integer[n]);

        // copy last N elements of array into temp
        for (int i = 0; i < n; i++) {
            temp.set(i, arr.get(len - n + i));
        }

        // shift original array
        for (int i = len - 1; i >= n; i--) {
            arr.set(i, arr.get(i - n));
        }

        // copy temp into original array
        for (int i = 0; i < n; i++) {
            arr.set(i, temp.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Array Before Rotation\n" + v1);
        rotate_array(v1, 2);
        System.out.println("Array After Rotation\n" + v1);

        List<Integer> v2 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Array Before Rotation\n" + v2);
        rotate_array(v2, -3);
        System.out.println("Array After Rotation\n" + v2);
    }
}