package week11d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisorFinderTest {

    @Test
    public void testDivisorFinder() {
        Assertions.assertEquals(1, new DivisorFinder().findDivisors(425));
        Assertions.assertEquals(0, new DivisorFinder().findDivisors(29));
        Assertions.assertEquals(2, new DivisorFinder().findDivisors(-15));
        Assertions.assertEquals(2, new DivisorFinder().findDivisors(4255));
        Assertions.assertEquals(2, new DivisorFinder().findDivisors(420));
    }
}
