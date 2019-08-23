/**
 * Runtime Complexity Polynomial, O(n3).
 * 
 * Memory Complexity Constant, O(1).
 */
class palindromeSubStrings {

    public static int find_all_palindrome_substrings(String input) {
        if (input == null) {
            return 0;
        }
        if (input.length() < 2) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (isPalindrome(input.substring(i, j + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isPalindrome(String str) {
        return str.equals(reverse(str));
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}