class sumCombinations {
    static void print(ArrayList<ArrayList<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < arr.get(i).size(); j++) {
                System.out.print(arr.get(i).get(j) + ", ");
            }
            System.out.println("]");
        }
    }

    static void print_all_sum_rec(int target, int current_sum, int start, ArrayList<ArrayList<Integer>> output,
            ArrayList<Integer> result) {

        if (target == current_sum) {
            output.add((ArrayList) result.clone());
        }

        for (int i = start; i < target; ++i) {
            int temp_sum = current_sum + i;
            if (temp_sum <= target) {

                result.add(i);
                print_all_sum_rec(target, temp_sum, i, output, result);
                result.remove(result.size() - 1);
            } else {
                return;
            }
        }
    }

    static ArrayList<ArrayList<Integer>> print_all_sum(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        print_all_sum_rec(target, 0, 1, output, result);
        return output;
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> result = print_all_sum(n);
        print(result);
    }
}