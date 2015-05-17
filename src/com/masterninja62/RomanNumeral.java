package com.masterninja62;


import java.util.*;

public class RomanNumeral {
    private static Map<Character, Integer> valid_characters = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    private static Map<Character, Integer> max_consecutive_characters = new HashMap<Character, Integer>() {{
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

    private Character getKey(Integer value, Map<Character, Integer> map){
        for(Character key : map.keySet()){
            if(map.get(key).equals(value))
                return key;
        }
        return null;
    }

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
            if ((i != 0) && (valid_characters.get(current_char) > 10 * valid_characters.get(last_char)))
                return "Invalid subtraction.";
            else if ((i != 0) && (valid_characters.get(last_char) < valid_characters.get(current_char))) {
                if (not_subtractable.contains(last_char))
                    return "Invalid subtraction.";
                else
                    //this is because it was added last iteration. Therefore must be subtracted twice to obtain desired affect
                    result -= 2 * valid_characters.get(last_char);
            }
            result += valid_characters.get(current_char);

            last_char = roman_numerals.charAt(i);
            if (max_consecutive_characters.get(last_char) < count)
                return "Too many consecutive characters. Valid cap is 3 for 'I', 'X', 'C', 'M' and 1 for 'V', 'L', 'D'.";
        }
        return Integer.toString(result);
    }


    public String arabic_to_roman(Integer arabic_numeral) {
        String result = "";
        if (arabic_numeral < 0)
            return "Negative numbers are not allowed.";
        int count = 0;
        while (arabic_numeral != 0) {
            //prevent more than 3 M's which can occur if large int passed in
            if ((arabic_numeral / 1000 > 0) && count < 3) {
                result += "M";
                arabic_numeral -= 1000;
                count++;
            } else if (arabic_numeral / 1000 > 0) {
                result += "CM";
                arabic_numeral -= 900;
                count = 1;
            } else {
                String stringified_arabic_numeral = Integer.toString(arabic_numeral);
                //below value is used to shorten code by knowing if value is in the 10, 100, 1000
                int current_weight_of_arabic_numeral = 1;
                for (int i = 0; i < stringified_arabic_numeral.length()-1; i++) {
                    current_weight_of_arabic_numeral *= 10;
                }
                int temp_val = arabic_numeral/current_weight_of_arabic_numeral;

                if (temp_val / 9 > 0) {
                    result += getKey(current_weight_of_arabic_numeral, valid_characters);
                    result += getKey(current_weight_of_arabic_numeral*10, valid_characters);
                    arabic_numeral -= 9 * current_weight_of_arabic_numeral;
                } else if (temp_val >=  5) {
                    result += getKey(current_weight_of_arabic_numeral*5, valid_characters);
                    arabic_numeral -= 5 * current_weight_of_arabic_numeral;
                }else if (temp_val / 4 > 0) {
                    result += getKey(current_weight_of_arabic_numeral, valid_characters);
                    result += getKey(current_weight_of_arabic_numeral*5, valid_characters);
                    arabic_numeral -= 4 * current_weight_of_arabic_numeral;
                } else {
                    result += getKey(current_weight_of_arabic_numeral, valid_characters);
                    arabic_numeral -= current_weight_of_arabic_numeral;
                }
            }
        }
        return result;
    }
}
