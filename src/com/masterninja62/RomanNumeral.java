package com.masterninja62;


import java.util.*;

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
    private static Set<Character> not_subtractable = new HashSet<>(Arrays.asList(
            new Character[]{'V', 'L', 'D'}));


    public String roman_to_arabic(String roman_numerals) {
        char last_char = 'Q'; //used as default as invalid according to valid_characters
        int count = 0;
        int result = 0;
        for (int i = 0; i < roman_numerals.length(); i++) {
            char current_char = roman_numerals.charAt(i);
            if (!valid_characters.containsKey(current_char))
                return "Non-valid character in input. Valid characters are '', 'I', 'V', 'X', 'L', 'C', 'D', 'M'";
            if (last_char == roman_numerals.charAt(i))
                count += 1;
            else
                count = 1;
            //determine subtraction
            if ((i != 0) && ((Integer) valid_characters.get(current_char) > 10 * (Integer) valid_characters.get(last_char)))
                return "Invalid subtraction.";
            else if ((i != 0) && ((Integer) valid_characters.get(last_char) < (Integer) valid_characters.get(current_char))) {
                if (not_subtractable.contains(last_char))
                    return "Invalid subtraction.";
                else
                    //this is because it was added last iteration. Therefore must be subtracted twice to obtain desired affect
                    result -= 2 * (Integer) valid_characters.get(last_char);
            }
            result += (Integer) valid_characters.get(current_char);

            last_char = roman_numerals.charAt(i);
            if ((Integer) max_consecutive_characters.get(last_char) < count)
                return "Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.";
        }
        return Integer.toString(result);
    }


    public String arabic_to_roman(Integer arabic_numeral) {
        String result = "";
        if (arabic_numeral < 0)
            return "Negative numbers are not allowed.";
        int count = 0;
        while (arabic_numeral > 0) {
            if ((arabic_numeral / 1000 > 0) && count < 3) {
                result += "M";
                arabic_numeral -= 1000;
                count++;
            } else if (arabic_numeral / 1000 > 0) {
                result += "CM";
                arabic_numeral -= 900;
                count = 1;
            } else if (arabic_numeral / 100 > 0) {
                if (arabic_numeral / 900 > 0) {
                    result += "CM";
                    arabic_numeral -= 900;
                } else if (arabic_numeral >= 500) {
                    result += "D";
                    arabic_numeral -= 500;
                }else if (arabic_numeral / 400 > 0) {
                    result += "CD";
                    arabic_numeral -= 400;
                } else {
                    result += "C";
                    arabic_numeral -= 100;
                }
            } else if (arabic_numeral / 10 > 0) {
                if (arabic_numeral / 90 > 0) {
                    result += "XC";
                    arabic_numeral -= 90;
                } else if (arabic_numeral >= 50) {
                    result += "L";
                    arabic_numeral -= 50;
                }else if (arabic_numeral / 40> 0) {
                    result += "XL";
                    arabic_numeral -= 40;
                } else {
                    result += "X";
                    arabic_numeral -= 10;
                }
            } else {
                if (arabic_numeral / 9 > 0) {
                    result += "IX";
                    arabic_numeral -= 9;
                } else if (arabic_numeral >=  5) {
                    result += "V";
                    arabic_numeral -= 5;
                }else if (arabic_numeral / 4 > 0) {
                    result += "IV";
                    arabic_numeral -= 4;
                } else {
                    result += "I";
                    arabic_numeral--;
                }
            }
        }
        return result;
    }
}
