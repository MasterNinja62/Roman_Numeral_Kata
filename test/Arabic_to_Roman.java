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

    @Test
    public void values_requiring_subtraction_to_appear() {
        assertEquals("IV", romanNumeral.arabic_to_roman(4));
        assertEquals("IX", romanNumeral.arabic_to_roman(9));
        assertEquals("XL", romanNumeral.arabic_to_roman(40));
        assertEquals("XC", romanNumeral.arabic_to_roman(90));
        assertEquals("CD", romanNumeral.arabic_to_roman(400));
        assertEquals("CM", romanNumeral.arabic_to_roman(900));
    }

    @Test
    public void values_requiring_consecutive_munerals_to_appear() {
        assertEquals("II", romanNumeral.arabic_to_roman(2));
        assertEquals("III", romanNumeral.arabic_to_roman(3));
        assertEquals("VII", romanNumeral.arabic_to_roman(7));
        assertEquals("VIII", romanNumeral.arabic_to_roman(8));
        assertEquals("XX", romanNumeral.arabic_to_roman(20));
        assertEquals("XXX", romanNumeral.arabic_to_roman(30));
        assertEquals("LXX", romanNumeral.arabic_to_roman(70));
        assertEquals("LXXX", romanNumeral.arabic_to_roman(80));
        assertEquals("CC", romanNumeral.arabic_to_roman(200));
        assertEquals("CCC", romanNumeral.arabic_to_roman(300));
        assertEquals("DCC", romanNumeral.arabic_to_roman(700));
        assertEquals("DCCC", romanNumeral.arabic_to_roman(800));
        assertEquals("MM", romanNumeral.arabic_to_roman(2000));
        assertEquals("MMM", romanNumeral.arabic_to_roman(3000));
    }


    @Test
    public void large_value_test() {
        assertEquals("MMMCMMC", romanNumeral.arabic_to_roman(5000));
    }

    @Test
    public void called_out_in_kata() {
        assertEquals("I", romanNumeral.arabic_to_roman(1));
        assertEquals("III", romanNumeral.arabic_to_roman(3));
        assertEquals("IX", romanNumeral.arabic_to_roman(9));
        assertEquals("MLXVI", romanNumeral.arabic_to_roman(1066));
        assertEquals("MCMLXXXIX", romanNumeral.arabic_to_roman(1989));
    }
}
