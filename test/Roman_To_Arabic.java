import com.masterninja62.RomanNumeral;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Roman_To_Arabic {

    RomanNumeral romanNumeral;

    @Before
    public void setup() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    public void empty_roman_numeral_is_valid() {
        //This test is to simple test that when no characters are provided
        //It is still deemed valid
        assertEquals("0", romanNumeral.roman_to_arabic(""));
    }

    @Test
    public void valid_roman_numeral_character_detected() {
        //This test is to simple test that only valid character are detected by
        //the code. Does not determine validity of format
        assertEquals("1", romanNumeral.roman_to_arabic("I"));
        assertEquals("5", romanNumeral.roman_to_arabic("V"));
        assertEquals("10", romanNumeral.roman_to_arabic("X"));
        assertEquals("50", romanNumeral.roman_to_arabic("L"));
        assertEquals("100", romanNumeral.roman_to_arabic("C"));
        assertEquals("500", romanNumeral.roman_to_arabic("D"));
        assertEquals("1000", romanNumeral.roman_to_arabic("M"));
    }

    @Test
    public void invalid_roman_numeral_character_detected() {
        //This test is to simple test that only valid character are detected by
        //the code. Does not determine validity of format
        assertEquals("Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'", romanNumeral.roman_to_arabic("A"));
        assertEquals("Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'", romanNumeral.roman_to_arabic("F"));
        assertEquals("Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'", romanNumeral.roman_to_arabic("1"));
        assertEquals("Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'", romanNumeral.roman_to_arabic("E"));
        assertEquals("Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'", romanNumeral.roman_to_arabic("^"));
        assertEquals("Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'", romanNumeral.roman_to_arabic("P"));
        assertEquals("Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'", romanNumeral.roman_to_arabic("J"));
    }

    @Test
    public void valid_roman_numeral_characters_detected() {
        //This test is to simple test that only valid characters are detected by
        //the code. Does not determine validity of format
        assertEquals("1666", romanNumeral.roman_to_arabic("MDCLXVI"));
    }

    @Test
    public void invalid_roman_numeral_characters_detected() {
        //This test is to simple test that only valid characters are detected by
        //the code. Does not determine validity of format
        assertEquals("Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'", romanNumeral.roman_to_arabic("AF1E^PJ"));
        assertEquals("Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'", romanNumeral.roman_to_arabic("LXIVECC"));
    }

    @Test
    public void max_consecutive_valid_single_roman_numeral() {
        //Max valid lengths are provided.
        //should all be valid
        assertEquals("3", romanNumeral.roman_to_arabic("III"));
        assertEquals("5", romanNumeral.roman_to_arabic("V"));
        assertEquals("30", romanNumeral.roman_to_arabic("XXX"));
        assertEquals("50", romanNumeral.roman_to_arabic("L"));
        assertEquals("300", romanNumeral.roman_to_arabic("CCC"));
        assertEquals("500", romanNumeral.roman_to_arabic("D"));
        assertEquals("3000", romanNumeral.roman_to_arabic("MMM"));
    }
    @Test
    public void beyond_max_consecutive_valid_single_roman_numeral() {
        //Beyond Max valid lengths are provided.
        //should all be invalid
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("IIII"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("VV"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("XXXX"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("LL"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("CCCC"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("DD"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("MMMM"));
    }


    @Test
    public void max_consecutive_valid_multiple_roman_numeral() {
        //Max valid lengths are provided.
        //should all be valid
        assertEquals("3888", romanNumeral.roman_to_arabic("MMMDCCCLXXXVIII"));
    }
    @Test
    public void beyond_max_consecutive_valid_multiple_roman_numeral() {
        //Beyond Max valid lengths are provided.
        //should all be invalid
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("MMMDCCCLXXXVIIII"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("MMMDCCCLXXXVVIII"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("MMMDCCCLXXXXVIII"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("MMMDCCCLLXXXVIII"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("MMMDCCCCLXXXVIII"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("MMMDDCCCLXXXVIII"));
        assertEquals("Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.", romanNumeral.roman_to_arabic("MMMMDCCCLXXXVIII"));
    }
    @Test
    public void valid_2_char_subtractions() {
        assertEquals("4", romanNumeral.roman_to_arabic("IV"));
        assertEquals("9", romanNumeral.roman_to_arabic("IX"));
        assertEquals("40", romanNumeral.roman_to_arabic("XL"));
        assertEquals("90", romanNumeral.roman_to_arabic("XC"));
        assertEquals("400", romanNumeral.roman_to_arabic("CD"));
        assertEquals("900", romanNumeral.roman_to_arabic("CM"));
    }

    @Test
    public void invalid_2_char_subtractions() {
        assertEquals("Invalid subtraction.", romanNumeral.roman_to_arabic("IL"));
        assertEquals("Invalid subtraction.", romanNumeral.roman_to_arabic("ID"));
        assertEquals("Invalid subtraction.", romanNumeral.roman_to_arabic("IC"));
        assertEquals("Invalid subtraction.", romanNumeral.roman_to_arabic("IM"));
        assertEquals("Invalid subtraction.", romanNumeral.roman_to_arabic("XD"));
        assertEquals("Invalid subtraction.", romanNumeral.roman_to_arabic("XM"));
    }


    @Test
    public void explicitly_called_out_in_kata() {
        assertEquals("1", romanNumeral.roman_to_arabic("I"));
        assertEquals("3", romanNumeral.roman_to_arabic("III"));
        assertEquals("9", romanNumeral.roman_to_arabic("IX"));
        assertEquals("1066", romanNumeral.roman_to_arabic("MLXVI"));
        assertEquals("1989", romanNumeral.roman_to_arabic("MCMLXXXIX"));
    }
}
