
/**
 * Runtime Complexity
Quadratic, O(n2).

Memory Complexity
Constant, O(1). */
import java.util.HashSet;
import java.util.LinkedList;

class MySolution {
    static void remove_duplicates(char[] str) {
        if (str == null || str.length < 2) {
            return;
        }
        HashSet<Character> set = new HashSet<>();
        int write = 0;
        int read = 0;
        while (str[read] != '\0') {
            if (!set.contains(str[read])) {
                set.add(str[read]);
                str[write] = str[read];
                write++;
            }
            read++;
        }
        str[write] = '\0';
    }

    public static void main(String[] args) {
        char[] c = { 'a', 'a', 'b' };
        remove_duplicates(c);
        for (char cc : c) {
            System.out.print(cc);
        }
    }
}