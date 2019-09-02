/**
 * Runtime Complexity O(n2logn). use binary search Memory Complexity Constant,
 * O(1).
 */
class sumOfThree {
    public static Boolean find_sum_of_three(int arr[], int required_sum) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == required_sum) {
                    return true;
                } else if (sum < required_sum) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return false;
    }

}