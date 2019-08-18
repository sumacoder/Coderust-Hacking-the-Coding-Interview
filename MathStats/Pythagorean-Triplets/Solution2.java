class pythagoreanTriplets {
    static List<int[]> find_pythagorean_triplets_2(int[] arr) {
        int n = arr.length;
        List<int[]> triplets = new ArrayList<int[]>();
        Arrays.sort(arr);

        for (int i = 0; i < n; ++i) {
            if (arr[i] == 0)
                continue;

            int c2 = arr[i] * arr[i];

            int j = 0;
            int k = n - 1;

            while (j < k) {
                if (j == i || arr[j] == 0) {
                    j += 1;
                    continue;
                }

                if (k == i || arr[k] == 0) {
                    k -= 1;
                    continue;
                }

                int a2 = arr[j] * arr[j];
                int b2 = arr[k] * arr[k];

                if (a2 + b2 == c2) {
                    triplets.add(new int[] { arr[i], arr[j], arr[k] });
                    break;
                } else if (a2 + b2 + (-c2) > 0) {
                    k -= 1;
                } else {
                    j += 1;
                }
            }
        }
        return triplets;
    }

    static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void main(String[] argv) {

        int[] l2 = { 3, 4, 5, 6, 8, 10, 9, 12, 15, 18, 19 };

        shuffleArray(l2);

        List<int[]> t2 = find_pythagorean_triplets_2(l2);

        System.out.println("***********");
        for (int[] a : t2) {
            for (int x : a) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}