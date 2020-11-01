package localvariables;

public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b;

        //System.out.println(b); // Kiakad az IDEA, mert a 'b' nincs inicializálva
        b=false;
        System.out.println(b); // Most már jó.

        int a=2;
        int i=4, j=5;
        int k=i;

        String s="Hello World!";
        String t=s;

        {
            int x=0;
            System.out.println(k);
        }
        // System.out.println(x); // A blokkon kívül már nem látszik
    }
}
