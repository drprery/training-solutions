package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons) {
        Salesperson salespersonMaxAboveTarget = null;

        for (Salesperson salesperson : salespersons) {
            if (salespersonMaxAboveTarget == null
                    || (salesperson.getDifferenceFromTarget() > 0 && salesperson.getDifferenceFromTarget() > salespersonMaxAboveTarget.getDifferenceFromTarget())) {
                salespersonMaxAboveTarget = salesperson;
            }
        }
        return salespersonMaxAboveTarget;
    }
}
