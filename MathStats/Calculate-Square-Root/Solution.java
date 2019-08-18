class squareRoot {
    private static final double EPSILON = 0.00001;

    public static double square_root_iterative(double num) {
        double n = num;
        while (n * n > num) {
            n = (n + num / n) / 2;
        }
        return n;
    }

}