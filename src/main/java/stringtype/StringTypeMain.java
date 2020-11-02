package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix="Hello ";
        String name="John Doe";
        String message=prefix+name;
        message=message+444;
        boolean b=message.equals("Hello John Doe");
        boolean c=message.equals("Hello John Doe444");

        String emptyStr1="";
        String emptyStr2="";
        String emptyStr3=emptyStr1+emptyStr2;
        System.out.println(emptyStr3.length());

        System.out.println("Abcde".length());
        System.out.println("Abcde".charAt(0)+","+"Abcde".charAt(2));
        System.out.println("Abcde".substring(0,2));
    }
}