package com.masterninja62;


import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {
    private static Map valid_characters = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    private static Map max_consecutive_characters = new HashMap<Character, Integer>() {{
        put('I', 3);
        put('V', 1);
        put('X', 3);
        put('L', 1);
        put('C', 3);
        put('D', 1);
        put('M', 3);
    }};
    public String roman_to_arabic(String roman_numerals) {
        char last_char = 'Q'; //used as default as invalid according to valid_characters
        int count = 0;
        int result = 0;
        for(int i = 0; i < roman_numerals.length(); i++) {
            char current_char = roman_numerals.charAt(i);
            if (!valid_characters.containsKey(current_char))
                return "Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'";
            if (last_char == roman_numerals.charAt(i))
                    count += 1;
            else
                count = 1;
            //determine subtraction
            if (( i != 0) &&((Integer) valid_characters.get(current_char) > 10 * (Integer) valid_characters.get(last_char)))
                return "Invalid subtraction.";
            else if (( i != 0) && ((Integer) valid_characters.get(last_char) < (Integer) valid_characters.get(current_char)))
                //this is because it was added last iteration. Therefore must be subtracted twice to obtain desired affect
                result -= 2 * (Integer) valid_characters.get(last_char);

            result += (Integer) valid_characters.get(current_char);

            last_char =  roman_numerals.charAt(i);
            if ((Integer) max_consecutive_characters.get(last_char) < count)
                return "Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.";


        }
        return Integer.toString(result);
    }


    public boolean contains_valid_integer(Integer arabic_numeral) {
        return (arabic_numeral >= 0);
    }
}
