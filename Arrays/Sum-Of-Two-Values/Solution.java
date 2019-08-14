// find_sum_of_two_2 function return true if
// there are two values in array who
// sum to value and returns false otherwise
// this solution works only if data is sorted.
// does not require any extra memory.
class findSum {
    static boolean find_sum_of_two_2(int[] A, int val) {

        for (int i = 0, j = A.length - 1; i < j;) {
            int sum = A[i] + A[j];
            if (sum == val) {
                return true;
            }

            if (sum < val) {
                ++i;
            } else {
                --j;
            }
        }

        return false;
    }

    static void test(int[] v, int val) {
        Arrays.sort(v);
        boolean output = find_sum_of_two_2(v, val);
        System.out.println("exist(A, " + val + ") = " + (output ? "true" : "false") + "\n");

    }

    public static void main(String[] args) {
        int[] v = new int[] { 2, 1, 8, 4, 7, 3 };
        test(v, 3);
        test(v, 20);
        test(v, 1);
        test(v, 2);
        test(v, 7);
    }
}