/**
 * Created by MasterNinja on 5/13/2015.
 */
import com.masterninja62.RomanNumeral;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class Roman_To_Arabic {
        @Test
        public void valid_roman_numeral_character_detected() {
            RomanNumeral romanNumeral = new RomanNumeral();
            assertEquals(true, romanNumeral.contains_valid_characters("I"));
        }
}
