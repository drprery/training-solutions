package algorithmsdecision.bankaccounts;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountDecisionMakerTest {

    List<BankAccount> accounts = List.of(
            new BankAccount("Fred", "123-324-123", 100),
            new BankAccount("Kate", "133-324-123", 200),
            new BankAccount("Mary", "143-324-123", 90)
    );

    @Test
    public void testContainsBalanceGreaterThan() {

        BankAccountDecisionMaker test = new BankAccountDecisionMaker();

        assertEquals(true, test.containsBalanceGreaterThan(accounts, 150));
        assertEquals(false, test.containsBalanceGreaterThan(accounts, 250));

    }

}
