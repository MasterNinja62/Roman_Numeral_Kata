import com.masterninja62.RomanNumeral;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Roman_To_Arabic {

    @Test
    public void empty_roman_numeral_is_valid() {
        //This test is to simple test that when no characters are provided
        //It is still deemed valid
        RomanNumeral romanNumeral = new RomanNumeral();
        assertEquals(true, romanNumeral.contains_valid_roman_characters(""));
    }

    @Test
    public void valid_roman_numeral_character_detected() {
        RomanNumeral romanNumeral = new RomanNumeral();
        assertEquals(true, romanNumeral.contains_valid_roman_characters("I"));
        assertEquals(true, romanNumeral.contains_valid_roman_characters("V"));
        assertEquals(true, romanNumeral.contains_valid_roman_characters("X"));
        assertEquals(true, romanNumeral.contains_valid_roman_characters("L"));
        assertEquals(true, romanNumeral.contains_valid_roman_characters("C"));
        assertEquals(true, romanNumeral.contains_valid_roman_characters("D"));
        assertEquals(true, romanNumeral.contains_valid_roman_characters("M"));
    }

    @Test
    public void invalid_roman_numeral_character_detected() {
        //This test is to simple test that only valid character are detected by
        //the code. Does not determine validity of format
        RomanNumeral romanNumeral = new RomanNumeral();
        assertEquals(false, romanNumeral.contains_valid_roman_characters("A"));
        assertEquals(false, romanNumeral.contains_valid_roman_characters("F"));
        assertEquals(false, romanNumeral.contains_valid_roman_characters("1"));
        assertEquals(false, romanNumeral.contains_valid_roman_characters("E"));
        assertEquals(false, romanNumeral.contains_valid_roman_characters("^"));
        assertEquals(false, romanNumeral.contains_valid_roman_characters("P"));
        assertEquals(false, romanNumeral.contains_valid_roman_characters("J"));
    }

    @Test
    public void valid_roman_numeral_characters_detected() {
        //This test is to simple test that only valid characters are detected by
        //the code. Does not determine validity of format
        RomanNumeral romanNumeral = new RomanNumeral();
        assertEquals(true, romanNumeral.contains_valid_roman_characters("IVXLMCC"));
        assertEquals(true, romanNumeral.contains_valid_roman_characters("VVIILMCC"));
    }

    @Test
    public void invalid_roman_numeral_characters_detected() {
        //This test is to simple test that only valid characters are detected by
        //the code. Does not determine validity of format
        RomanNumeral romanNumeral = new RomanNumeral();
        assertEquals(false, romanNumeral.contains_valid_roman_characters("AF1E^PJ"));
        assertEquals(false, romanNumeral.contains_valid_roman_characters("IVXLECC"));
    }
}
