/**
 * Runtime Complexity Polynomial, O(n3).
 * 
 * Memory Complexity Constant, O(1).
 */
class pythagoreanTriplet {
    static List<int[]> find_pythagorean_triplets(int[] arr) {
        List<int[]> triplets = new ArrayList<int[]>();
        if (arr.length < 3) {
            return triplets;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == 0)
                continue;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] == 0)
                    continue;
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] * arr[i] + arr[j] * arr[j] == arr[k] * arr[k]) {

                        triplets.add(new int[] { arr[i], arr[j], arr[k] });
                    }
                }
            }
        }
        return triplets;
    }
}