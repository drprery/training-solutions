package statements;

import java.util.Scanner;

public class InvestmentMain {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("A befektetési összeg: ");
        int amount=scanner.nextInt();

        System.out.println("A kamatláb: ");
        int interestRate=scanner.nextInt();

        Investment investment=new Investment(amount, interestRate);

        System.out.println("A tőke mennyisége: " + investment.getFund());
        System.out.println("A hozam 90 napra: " + investment.getYield(90));
        System.out.println("A felvehető összeg 120 nap után: " + investment.close(120));
        System.out.println("A felvehető összeg 121 nap után: " + investment.close(121));
    }
}