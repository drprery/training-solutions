package week05d02;

public class ChangeLetter {
    public String changeVowels(String str){
            String temp="";

            if (str==null){
                throw new IllegalArgumentException("Incorrect parameter string!");
            }

            temp=str.replace("a","*");
            temp=temp.replace("e","*");
            temp=temp.replace("i","*");
            temp=temp.replace("o","*");
            temp=temp.replace("u","*");
        return temp;
    }
}
