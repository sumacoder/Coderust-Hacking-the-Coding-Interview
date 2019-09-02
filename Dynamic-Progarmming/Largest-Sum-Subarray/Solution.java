/**
 * Runtime Complexity Linear, O(n).
 * 
 * Memory Complexity Constant, O(1).
 */
class largestSum {
    static int find_max_sum_sub_array(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int current_max = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            // if they plus together will be less
            if (current_max < 0) {
                current_max = A[i];
            } else {
                current_max += A[i];
            }
            if (current_max > max) {
                max = current_max;
            }
        }
        return max;
    }
}