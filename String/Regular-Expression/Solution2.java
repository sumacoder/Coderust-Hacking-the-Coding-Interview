/**
 * Runtime Complexity Exponential.
 * 
 * Memory Complexity Exponential.
 */
class regxMatch {
    static boolean match(String text, String pattern, int i, int j) {
        if (text.length() == i && pattern.length() == j) {
            return true;
        }

        if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
            for (int k = i; k <= text.length(); ++k) {
                if (match(text, pattern, k, j + 2)) {
                    return true;
                }

                if (k >= text.length()) {
                    return false;
                }

                if (pattern.charAt(j) != '.' && text.charAt(k) != pattern.charAt(j)) {
                    return false;
                }
            }
        } else if (i < text.length() && j < pattern.length()
                && (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i))) {
            return match(text, pattern, i + 1, j + 1);
        }

        return false;
    }

    public static boolean match(String text, String pattern) {
        return match(text, pattern, 0, 0);
    }

    public static void test(String s, String p) {
        boolean output = match(s, p);

        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);

        if (output) {
            System.out.println(s + " " + p + " matched - ");
        } else {
            System.out.println(s + " " + p + " did not match - ");
        }
    }

    public static void main(String[] args) {
        test("abb", "abb");
        test("abbc", "ab*c");
        test("abb", "ab*");

        test("", "b*c");
        test("a", "ab*");

        test("aaabbbbbcccd", "a*bbb*c*d");
        test("a", "ab*");
        test("aaabbbbbcccd", "a*bbb*.*d");
        test("aaabbbbbcccde", "a*bbb*.*d");
        test("b", "b*");
        test("aabcd", "aa*d");
        test("", "aa*d");
        test("", "a*");
        test("b", "b*c");
    }
}