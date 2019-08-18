import java.util.*;

class MySolution {
    static int find_missing(List<Integer> input) {
        int n = missingInt(input);
        if (n == 0) {
            return -1;
        }

        return n;
    }

    static int missingInt(List<Integer> input) {
        if (input.size() == 0) {
            return -1;
        }
        int n = input.size();

        int expectedSum = (n + 2) * (n + 1) / 2;

        int actualSum = 0;

        for (int num : input) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(4);
    }
}