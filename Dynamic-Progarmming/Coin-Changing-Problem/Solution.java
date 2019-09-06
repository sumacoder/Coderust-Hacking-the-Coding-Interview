/**
 * Runtime Complexity O(m n) where m is number of denominations and n is amount.
 * 
 * Memory Complexity Linear, O(n) where n is the amount.
 */
class coinChanging {
    static int solve_coin_change_dp(int[] denominations, int amount) {
        // this solution requires O(amount) space to store solution
        // until current amount.
        int[] solution = new int[amount + 1];
        solution[0] = 1;

        for (int den : denominations) {
            for (int i = den; i < (amount + 1); ++i) {
                solution[i] += solution[i - den];
            }
        }
        return solution[solution.length - 1];
    }

    public static void main(String[] args) {

        int[] denominations = new int[] { 1, 5, 10 };
        System.out.println("Combinations (DP): " + solve_coin_change_dp(denominations, 356));
    }
}