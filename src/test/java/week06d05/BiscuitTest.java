package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiscuitTest {

    @Test
    public void createBiscuit(){
        Biscuit biscuit= new Biscuit();
        biscuit= Biscuit.of(BiscuitType.BOUNTY, 50);

        assertEquals("BOUNTY, 50 gram",biscuit.getType()+", "+biscuit.getGramAmount()+" gram");
        System.out.println(biscuit.getType()+", "+biscuit.getGramAmount()+" gram");
    }

}
