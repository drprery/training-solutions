package week05d02;

public class ChangeLetter {
    public static final String CHARS="aeiou";

    public String changeVowels(String str){
            String temp="";

            if (str==null){
                throw new IllegalArgumentException("Incorrect parameter string!");
            }

            for(int i=0;i<str.length();i++) {
                if (CHARS.contains(str.substring(i, i + 1))) {
                    temp = temp + "*";
                } else {
                    temp = temp + str.substring(i, i + 1);
                }
            }

        return temp;
    }
}
