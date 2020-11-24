package algorithmssum.sales;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesAmountSumCalculatorTest {

    @Test
    public void testSumSalesAmount() {
        SalesAmountSumCalculator test = new SalesAmountSumCalculator();

        List<Salesperson> salespersons = List.of(
                new Salesperson("János", 600),
                new Salesperson("Katalin", 200),
                new Salesperson("Márk", 700)
                );

        assertEquals(1500, test.sumSalesAmount(salespersons));

    }

}
