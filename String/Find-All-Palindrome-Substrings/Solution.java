/**
 * Runtime Complexity Polynomial, O(n2).
 * 
 * Memory Complexity Constant, O(1).
 */
class palindromeSubstrings {
    public static int find_palindromes_in_sub_string(String input, int j, int k) {
        int count = 0;
        for (; j >= 0 && k < input.length(); --j, ++k) {
            if (input.charAt(j) != input.charAt(k)) {
                break;
            }
            System.out.print(input.substring(j, k + 1) + ", ");
            count++;
        }
        return count;
    }

    public static int find_all_palindrome_substrings_2(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); ++i) {
            count += find_palindromes_in_sub_string(input, i - 1, i + 1);
            count += find_palindromes_in_sub_string(input, i, i + 1);
        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        String str = "aabbbaa";
        int count = find_all_palindrome_substrings_2(str);
        System.out.println(count == 7);
    }
}