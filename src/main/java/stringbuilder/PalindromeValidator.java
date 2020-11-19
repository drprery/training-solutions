package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }
        //trim() nélkül bukik az utolsó teszt
        text = text.trim();

        StringBuilder sb = new StringBuilder(text);
        return text.equalsIgnoreCase(sb.reverse().toString());
    }
}