import com.incubyte.hiring.StringCalculator;
import org.junit.Test;

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

}
