package week05d02;

public class ChangeLetter {
    public static final String CHARS="aeiou";

    public String changeVowels(String str){

            String actualChar="";
            StringBuilder sb=new StringBuilder("");

            if (str==null){
                throw new IllegalArgumentException("Incorrect parameter string!");
            }

            for(int i=0;i<str.length();i++) {
                actualChar=str.substring(i, i + 1);

                if (CHARS.contains(actualChar)) {
                    sb.append("*");
                } else {
                    sb.append(actualChar);
                }
            }

        return sb.toString();
    }
}
