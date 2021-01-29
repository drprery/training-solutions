package week13d05;

import java.util.HashSet;
import java.util.Set;

public class SumOfLetters {
    private Set<Character> characters = new HashSet<>();

    public int sumLetters(String str) {

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                characters.add(ch);
            }
        }
        return characters.size();
    }

    public static void main(String[] args) {
        SumOfLetters sumOfLetters = new SumOfLetters();
        System.out.println(sumOfLetters.sumLetters("ATfdWTÉéáőT423@"));
    }
}

