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

    public boolean contains_valid_roman_characters(String roman_numerals) {
        for(int i = 0; i < roman_numerals.length(); i++) {
            if (!valid_characters.containsKey(roman_numerals.charAt(i)))
                return false;
        }
        return true;
    }
}
