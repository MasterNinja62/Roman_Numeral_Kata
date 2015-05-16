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
        assertEquals(false, romanNumeral.contains_valid_integer(-1));
        assertEquals(false, romanNumeral.contains_valid_integer(-10));
        assertEquals(false, romanNumeral.contains_valid_integer(-42));
    }

    @Test
    public void zero_is_valid() {
        assertEquals(true, romanNumeral.contains_valid_integer(0));
    }

    @Test
    public void a_positive_integer_is_valid() {
        assertEquals(true, romanNumeral.contains_valid_integer(1));
        assertEquals(true, romanNumeral.contains_valid_integer(10));
        assertEquals(true, romanNumeral.contains_valid_integer(42));
    }
}
