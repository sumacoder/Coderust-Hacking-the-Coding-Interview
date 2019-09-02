/**
 * Runtime Complexity Linear, O(n). use n1 n2 to memorize all the number Memory
 * Complexity Constant, O(1).
 */
class fib {
    static int get_fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        // fib(n) = fib(n-1) + fib(n-2)

        int n_1 = 1; // (n-1)
        int n_2 = 0; // (n-2)
        int res = 0;

        for (int i = 2; i <= n; ++i) {

            res = n_1 + n_2;

            n_2 = n_1;
            n_1 = res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("get_fib(5) = " + get_fibonacci(5)); // 5
        System.out.println("get_fib(5) = " + get_fibonacci(9)); // 34
    }
}