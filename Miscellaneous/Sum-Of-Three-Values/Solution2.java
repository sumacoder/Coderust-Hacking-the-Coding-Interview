/**
 * Runtime Complexity O(n2logn).
 * 
 * Memory Complexity Constant, O(1).
 */
class sumOfThree {
    public static Boolean find_sum_of_three_v2(int arr[], int required_sum) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                // Looking for required_sum = arr[i]+arr[j]+arr[k]
                int remaining_sum = required_sum - arr[i] - arr[j];
                // built-in binary search
                int k = Arrays.binarySearch(arr, remaining_sum);
                if (k > 0 && k != i && k != j) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { -25, -10, -7, -3, 2, 4, 8, 10 };
        System.out.println("-8: " + find_sum_of_three_v2(arr, -8));
        System.out.println("-25: " + find_sum_of_three_v2(arr, -25));
        System.out.println("0: " + find_sum_of_three_v2(arr, 0));
        System.out.println("-42: " + find_sum_of_three_v2(arr, -42));
        System.out.println("22: " + find_sum_of_three_v2(arr, 22));
        System.out.println("-7: " + find_sum_of_three_v2(arr, -7));
        System.out.println("-3: " + find_sum_of_three_v2(arr, -3));
        System.out.println("2: " + find_sum_of_three_v2(arr, 2));
        System.out.println("4: " + find_sum_of_three_v2(arr, 4));
        System.out.println("8: " + find_sum_of_three_v2(arr, 8));
        System.out.println("7: " + find_sum_of_three_v2(arr, 7));
        System.out.println("1: " + find_sum_of_three_v2(arr, 1));
    }
}