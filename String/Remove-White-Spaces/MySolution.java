/**
 * Runtime Complexity Linear, O(n).
 * 
 * Memory Complexity Constant, O(1).
 */
class MySolution {
    static void remove_white_spaces(char[] s) {
        if (s == null) {
            return;
        }
        if (s.length == 1 && s[0] == ' ') {
            return;
        }

        int write = 0;
        int read = 0;
        while (s[read] != '\0') {
            if (s[read] != '\t' && s[read] != ' ') {
                s[write] = s[read];
                write++;
            }
            read++;
        }
        s[write] = '\0';

    }

    public static void main(String[] args) {
        char[] c = { '\t', 'a', '\t', 'b' };
        remove_white_spaces(c);
        for (char cc : c) {
            System.out.print(cc);
        }
    }
}