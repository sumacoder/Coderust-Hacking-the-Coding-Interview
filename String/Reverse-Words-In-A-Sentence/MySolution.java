import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class test {

    public static void main(String[] args) {
        String s = "Quick brown fox jumped over the lazy dog";
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }
        reverse_words(c);
        for (char cc : c) {
            System.out.print(cc);
        }
    }

    public static void reverse_words(char[] sentence) {
        if (sentence == null || sentence.length == 0 || sentence.length == 1) {
            return;
        }

        reverse_word(sentence, 0, sentence.length - 1);
        int start = 0;

        for (int end = start; end < sentence.length; end++) {
            if (sentence[end] == ' ') {
                reverse_word(sentence, start, end - 1);
                start = end + 1;
            }
            if (end == sentence.length - 1) {
                reverse_word(sentence, start, end);
            }
        }

    }

    public static void reverse_word(char[] sentence, int start, int end) {
        if (sentence == null || sentence.length < 2) {
            return;
        }
        while (start < end) {
            char temp = sentence[start];
            sentence[start] = sentence[end];
            sentence[end] = temp;
            start++;
            end--;
        }
    }
}
