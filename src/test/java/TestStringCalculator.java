import com.incubyte.hiring.StringCalculator;
import com.incubyte.hiring.exception.NegativesNumbersException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TestStringCalculator {

    StringCalculator sc = new StringCalculator();
    @Test
    public void testEmpty(){
        assertEquals(0, sc.add(""));
    }

    @Test
    public void testNull(){
        assertEquals(0, sc.add(null));
    }

    @Test
    public void testSingValue(){
        assertEquals(3, sc.add("3"));
    }

    @Test
    public void testTwoValues(){
        assertEquals(9, sc.add("4,5"));
    }

    @Test
    public void testMorethanTwoValues(){
        assertEquals(16, sc.add("1,2,4,9,0"));
    }

    @Test
    public void testIgnoreNewLine(){
        assertEquals(6, sc.add("1\n2,3"));
    }

    @Test
    public void testWithDifferentDeliminators(){
        assertEquals(3, sc.add("//;\n1;2"));
    }

    @Test
    public void testNumbersGreaterThan1000(){
        assertEquals(8, sc.add("//;\n1;2;1001;5;9000"));
        assertEquals(1008, sc.add("//;\n1;2;1000;5;9000"));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testNegativeNumbers(){
        exceptionRule.expect(NegativesNumbersException.class);
        exceptionRule.expectMessage("negatives not allowed:-1 ");
        sc.add("-1");
    }

    @Test
    public void testNegativeNumbersCustomDelims(){
        exceptionRule.expect(NegativesNumbersException.class);
        exceptionRule.expectMessage("negatives not allowed:-22 -9 ");
        sc.add("//;\n1;-22;1000;5;-9");
    }

    @Test
    public void testMulLenDelims(){
        assertEquals(6, sc.add("//[***]\n1***2***3"));
        assertEquals(6, sc.add("//[+++++]\n1+++++2+++++3"));
    }
    @Test
    public void testMultipleDelims(){
        assertEquals(6, sc.add("//[*][%]\n1*2%3"));
        assertEquals(15, sc.add("//[*][%][+]\n1*2%3+9"));
    }

    @Test
    public void testMUltiLenMultipleDelims(){
        assertEquals(6, sc.add("//[***][%%%]\n1***2%%%3"));
        assertEquals(15, sc.add("//[+++][%][,,]\n1+++2,,3,,9"));
    }


}
