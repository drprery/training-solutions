package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersons) {
        Salesperson salespersonMaxBelowTarget = null;

        for (Salesperson salesperson : salespersons) {
            if (salespersonMaxBelowTarget == null
                    || (salesperson.getDifferenceFromTarget() < 0 && salesperson.getDifferenceFromTarget() < salespersonMaxBelowTarget.getDifferenceFromTarget())) {
                salespersonMaxBelowTarget = salesperson;
            }
        }
        return salespersonMaxBelowTarget;
    }
}
