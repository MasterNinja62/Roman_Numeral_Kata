import com.masterninja62.RomanNumeral;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Roman_To_Arabic {
    @Test
    public void valid_roman_numeral_character_detected() {
        RomanNumeral romanNumeral = new RomanNumeral();
        assertEquals(true, romanNumeral.contains_valid_characters("I"));
        assertEquals(true, romanNumeral.contains_valid_characters("V"));
        assertEquals(true, romanNumeral.contains_valid_characters("X"));
        assertEquals(true, romanNumeral.contains_valid_characters("L"));
        assertEquals(true, romanNumeral.contains_valid_characters("C"));
        assertEquals(true, romanNumeral.contains_valid_characters("D"));
        assertEquals(true, romanNumeral.contains_valid_characters("M"));
    }

    @Test
    public void invalid_roman_numeral_character_detected() {
        RomanNumeral romanNumeral = new RomanNumeral();
        assertEquals(false, romanNumeral.contains_valid_characters("A"));
        assertEquals(false, romanNumeral.contains_valid_characters("F"));
        assertEquals(false, romanNumeral.contains_valid_characters("1"));
        assertEquals(false, romanNumeral.contains_valid_characters("E"));
        assertEquals(false, romanNumeral.contains_valid_characters("^"));
        assertEquals(false, romanNumeral.contains_valid_characters("P"));
        assertEquals(false, romanNumeral.contains_valid_characters("J"));
    }
}
