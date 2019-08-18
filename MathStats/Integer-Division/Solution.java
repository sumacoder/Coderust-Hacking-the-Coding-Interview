class Solution {
    public int divide(int dividend, int divisor) {

        if (divisor == 0) {
            return -1;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == 0) {
            return 0;
        }
        long sign = 1;

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long res;
        res = ldivid(ldividend, ldivisor);

        int ans;
        // check over flow
        if (res > Integer.MAX_VALUE) {
            ans = sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            ans = (int) (sign * res);
        }
        return ans;
    }

    public long ldivid(long a, long b) {
        if (a < b)
            return 0;
        long p = 1;
        long val = b;
        while (val < a) {
            val <<= 1;
            p <<= 1;
        }

        if (val > a) {
            val >>= 1;
            p >>= 1;
            return p + ldivid(a - val, b);
        } else {
            return p;

        }
    }
}