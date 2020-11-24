package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons) {
        Salesperson salespersonMax = null;
        for (Salesperson salesperson : salespersons) {
            if (salespersonMax == null || salesperson.getAmount() > salespersonMax.getAmount()) {
                salespersonMax = salesperson;
            }
        }
        return salespersonMax;
    }
}
