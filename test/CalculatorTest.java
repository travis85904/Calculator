import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {

    @Test
    public void fiveTimesTenEqualFifty() {
        assertEquals(new Calculator().multiply(5, 10), 50);
    }

    @Test
    public void ninePlusSevenEqualsSixteen() {
        assertEquals(new Calculator().add(9, 7), 16);
    }


}