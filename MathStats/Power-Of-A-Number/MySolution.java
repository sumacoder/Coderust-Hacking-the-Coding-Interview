class powerNum {
    static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = 1;

        for (int i = 1; i <= Math.abs(n); i++) {
            res = res * x;
        }
        if (n < 0) {
            return 1 / res;
        }
        return res;
    }
}