package week14d04;

import java.util.*;

public class ContractCreator {

    private Contract template;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        this.template = new Contract(client, monthlyPrices);
    }

    public Contract create(String name) {

        return new Contract(name, new ArrayList<>(template.getMonthlyPrices()));
    }
}
