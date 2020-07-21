package helper;

import com.incubyte.hiring.helper.StringCalculatorHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStringCalculatorHelper {
    StringCalculatorHelper sch = new StringCalculatorHelper();

    @Test
    public void testNumberLessThan1000(){
        assertTrue(sch.numberLessThan1000("897"));
        assertFalse(sch.numberLessThan1000("2000"));
    }

    @Test
    public void testNegativeNumbers(){
        assertTrue(sch.isNegative(-9));
        assertFalse(sch.isNegative(9));
    }
}
