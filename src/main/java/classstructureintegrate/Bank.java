package classstructureintegrate;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.println("A bankszámla száma ?");
        String firstAccountNumber=scanner.nextLine();

        System.out.println("A tulajdonos neve ?");
        String firstOwner=scanner.nextLine();

        System.out.println("Nyitó összeg ?");
        int firstAmount=scanner.nextInt();

        scanner.nextLine();

        BankAccount firstAccount=new BankAccount(firstAccountNumber, firstOwner, firstAmount);

        System.out.println("A bankszámla száma ?");
        String secondAccountNumber=scanner.nextLine();

        System.out.println("A tulajdonos neve ?");
        String secondOwner=scanner.nextLine();

        System.out.println("Nyitó összeg ?");
        int secondAmount=scanner.nextInt();

        BankAccount secondAccount=new BankAccount(secondAccountNumber, secondOwner, secondAmount);

        System.out.println(firstAccount.getInfo());
        System.out.println(secondAccount.getInfo());

        System.out.println("Befizetés az első számlára: ");

        int depositAmount=scanner.nextInt();
        firstAccount.deposit(depositAmount);

        System.out.println(firstAccount.getInfo());

        System.out.println("Felvétel a második számláról: ");

        int withdrawAmount=scanner.nextInt();
        secondAccount.withdraw(withdrawAmount);

        System.out.println(secondAccount.getInfo());

        System.out.println("Átutalás összege az első számláról a másodikra ?");

        int transferAmount=scanner.nextInt();
        firstAccount.transfer(secondAccount, transferAmount);

        System.out.println(firstAccount.getInfo());
        System.out.println(secondAccount.getInfo());
    }
}
