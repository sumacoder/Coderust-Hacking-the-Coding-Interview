class powerNum {
    static double power_rec(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        double temp = power_rec(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    static double power(double x, int n) {
        boolean is_negative = false;
        if (n < 0) {
            is_negative = true;
            n *= -1;
        }

        double result = power_rec(x, n);

        if (is_negative) {
            return 1 / result;
        }

        return result;
    }

    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public static double round(double value) {
        return round(value, 6);
    }

    public static void main(String[] args) {
        int pass_count = 0, fail_count = 0;
        for (double n = -10.9876; n <= 5.987; n = round(n + 0.1)) {
            for (int k = -4; k <= 6; ++k) {
                double r1 = round(power(round(n), k));
                double r2 = round(Math.pow(round(n), k));
                double diff = r1 - r2;
                if (diff < 0) {
                    diff = diff * -1;
                }
                if (diff > 0.0000000001) {
                    String msg = String.format("r1 = %f, r2 = %f, difference = %f", r1, r2, diff);
                    System.out.println("Failed for (" + n + ", " + k + ") " + msg);
                    fail_count++;
                } else {
                    pass_count++;
                }

                System.out.println(diff <= 0.0000000001);
            }
        }
        System.out.printf("Passed Count: %d, Fail Count: %d\n", pass_count, fail_count);
    }
}