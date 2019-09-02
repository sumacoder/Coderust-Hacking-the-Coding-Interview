/**
 * Runtime Complexity Exponential, O(2n). Memory Complexity Linear, O(n).
 * 
 * 
 */
class fib {
    static int get_fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return get_fibonacci(n - 1) + get_fibonacci(n - 2);
    }
}