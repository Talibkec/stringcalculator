package parser;

import com.incubyte.hiring.parser.StringCalculatorParser;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestStringCaculatorParser {
    StringCalculatorParser scp = new StringCalculatorParser();

    @Test
    public void testNumbers(){
        List<String> numbers = scp.getNumbers("1;2", ";");
        assertEquals("1", numbers.get(0));
        assertEquals("2", numbers.get(1));
        numbers = scp.getNumbers("1+++++2+++++3", "+++++");
        assertEquals("1", numbers.get(0));
        assertEquals("2", numbers.get(1));
        assertEquals("3", numbers.get(2));
    }

    @Test
    public void testDeliminators(){
        assertEquals("***", scp.getDeliminators("//[***]\n1***2***3"));
        assertEquals("*%+", scp.getDeliminators("//[*][%][+]\n1*2%3+9"));
        assertEquals("+++%,,", scp.getDeliminators("//[+++][%][,,]\n1+++2,,3,,9"));
    }

    @Test
    public void testNumberString(){
        assertEquals("1***2***3", scp.getNumSubString("//[***]\n1***2***3"));
        assertEquals("1,2,3", scp.getNumSubString("1\n2,3"));
        assertEquals("1+++2,,3,,9", scp.getNumSubString("//[+++][%][,,]\n1+++2,,3,,9"));
    }

    @Test
    public void testRemoveNewLineChars(){
        assertEquals("1,2,3", scp.removeNewLineChars("1\n2,3"));
    }

}
