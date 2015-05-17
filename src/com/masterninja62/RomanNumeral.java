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
        char last_char = 'Q';
        int count = 0;
        int result = 0;
        for(int i = 0; i < roman_numerals.length(); i++) {
            if (!valid_characters.containsKey(roman_numerals.charAt(i)))
                return "Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'";
            if (last_char == roman_numerals.charAt(i))
                    count += 1;
            else
                count = 1;
            last_char =  roman_numerals.charAt(i);
            if ((Integer) max_consecutive_characters.get(last_char) < count)
                return "Too many consecutive characters. Valid cap is 'I', 'X', 'C', 'M' 3 times and  'V', 'L', 'D', 1 time.";

        }
        return Integer.toString(result);
    }


    public boolean contains_valid_integer(Integer arabic_numeral) {
        return (arabic_numeral >= 0);
    }
}
