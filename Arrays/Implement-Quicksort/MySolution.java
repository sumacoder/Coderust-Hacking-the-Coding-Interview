class MySolution {
    static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low];
        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;

        return j;

    }

    static void quick_sort(int[] arr, int low, int high) {
        if (high > low) {
            int pivot = partition(arr, low, high);

            quick_sort(arr, low, pivot - 1);
            quick_sort(arr, pivot + 1, high);
        }
    }

    static void quick_sort(int[] arr) {
        if (arr.length <= 1 || arr == null) {
            return;
        }
        quick_sort(arr, 0, arr.length - 1);
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