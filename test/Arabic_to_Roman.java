import com.masterninja62.RomanNumeral;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class Arabic_to_Roman {

    RomanNumeral romanNumeral;

    @Before
    public void setup() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    public void a_negative_integer_is_invalid() {
        //This test is to simple test that when an integer it is not valid
        //This is due to kata declaring its a character conversion
        //a negative is never called as acceptable
        assertEquals("Negative numbers are not allowed.", romanNumeral.arabic_to_roman(-1));
        assertEquals("Negative numbers are not allowed.", romanNumeral.arabic_to_roman(-10));
        assertEquals("Negative numbers are not allowed.", romanNumeral.arabic_to_roman(-42));
    }

    @Test
    public void zero_is_valid() {
        assertEquals("", romanNumeral.arabic_to_roman(0));
    }

    @Test
    public void basic_translation() {
        assertEquals("I", romanNumeral.arabic_to_roman(1));
        assertEquals("V", romanNumeral.arabic_to_roman(5));
        assertEquals("X", romanNumeral.arabic_to_roman(10));
        assertEquals("L", romanNumeral.arabic_to_roman(50));
        assertEquals("C", romanNumeral.arabic_to_roman(100));
        assertEquals("D", romanNumeral.arabic_to_roman(500));
        assertEquals("M", romanNumeral.arabic_to_roman(1000));
    }
}
