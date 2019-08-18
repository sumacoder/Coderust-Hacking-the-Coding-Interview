class Solution {
    public String getPermutation(int n, int k) {
        if (n == 0 || k < 1) {
            return "";
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backTracking(list, new ArrayList<>(), new boolean[n], arr);

        StringBuilder sb = new StringBuilder("");
        if (k > list.size()) {
            return "";
        }
        for (int l : list.get(k - 1)) {
            sb.append(Integer.toString(l));
        }
        return sb.toString();

    }

    public void backTracking(List<List<Integer>> list, List<Integer> subList, boolean[] used, int[] nums) {
        if (subList.size() == nums.length) {
            list.add(new ArrayList<>(subList));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                subList.add(nums[i]);
                backTracking(list, subList, used, nums);
                subList.remove(subList.get(subList.size() - 1));
                used[i] = false;
            }
        }
    }

}