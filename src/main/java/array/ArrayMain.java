package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] daysOfWeek=new String[]{"Hétfő","Kedd","Szerda","Csütörtök","Péntek","Szombat","Vasárnap"};
        System.out.println(daysOfWeek[1]);
        System.out.println(daysOfWeek.length);

        int[] powersOfTwo=new int[5];
        for (int i=1,j=0;i<=16;i*=2){
            powersOfTwo[j++]=i;
        }
        for (int i:powersOfTwo){
            System.out.println(i);
        }

        boolean[] bools=new boolean[6];
        for (int i=1;i<6;i++){
            bools[i]=!(bools[i-1]);
        }
        for (boolean b:bools){
            System.out.println(b);
        }
    }
}
