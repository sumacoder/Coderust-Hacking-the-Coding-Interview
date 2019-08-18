class sumCombinations {
    static ArrayList<ArrayList<Integer>> print_all_sum(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            return output;
        }
        int[] arr = new int[target - 1];
        for (int i = 1; i <= target - 1; i++) {
            arr[i - 1] = i;
        }
        backTracking(output, new ArrayList<>(), arr, target, 0);
        return output;
    }

    static void backTracking(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> subList, int[] nums, int remainder,
            int start) {
        if (remainder == 0) {
            list.add(new ArrayList<>(subList));
        }
        if (remainder < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            subList.add(nums[i]);
            backTracking(list, subList, nums, remainder - nums[i], i);
            subList.remove(subList.get(subList.size() - 1));
        }
    }
}