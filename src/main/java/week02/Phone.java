package week02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type=type;
        this.mem=mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type=type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem=mem;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("A telefon típusa: ");
        String phoneType = sc.nextLine();
        System.out.println("A telefon memóriájának a mennyisége: ");
        int phoneMem=sc.nextInt();
        Phone phone=new Phone(phoneType,phoneMem);

        System.out.println("A telefon márkája: "+phone.getType()+", memóriája "+phone.getMem()+"Gb Ram");
    }
}
