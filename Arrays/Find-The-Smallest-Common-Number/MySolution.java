/**
 * Runtime Complexity The runtime complexity of the code is Linear, O(n).
 * 
 * Memory Complexity The memory complexity of the code is Constant, O(1).
 */
class MySolution {
    static Integer find_least_common_number(int[] arr1, int[] arr2, int[] arr3) {
        if (arr1.length == 0 || arr2.length == 0 || arr3.length == 0) {
            return -1;
        }
        int size1 = arr1.length;
        int size2 = arr2.length;
        int size3 = arr3.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < size1 && j < size2 && k < size3) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                return arr1[i];
            }
            int curr_min = Math.min(Math.min(arr1[i], arr2[j]), arr3[k]);
            if (arr1[i] == curr_min) {
                i++;
            } else if (arr2[j] == curr_min) {
                j++;
            } else {
                k++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] v1 = new int[] { 1, 6, 10, 14, 50 };
        int[] v2 = new int[] { -1, 6, 7, 8, 50 };
        int[] v3 = new int[] { 0, 6, 7, 10, 25, 30, 40 };
        Integer result = find_least_common_number(v1, v2, v3);
        System.out.println("Least Common Number: " + result);
    }
}